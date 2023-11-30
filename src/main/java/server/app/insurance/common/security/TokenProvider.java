package server.app.insurance.common.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import server.app.insurance.common.exception.BizException;
import server.app.insurance.user.customer.dto.TokenInfoResponse;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.customer.repository.RefreshTokenRepository;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static server.app.insurance.user.customer.state.CustomerResponseType.*;
import static server.app.insurance.common.security.state.JwtException.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class TokenProvider implements InitializingBean {


    private static final String AUTHORITIES_KEY = "auth";
    private static final String ADDITIONAL_INFO = "isAdditionalInfoProvided";
    private static final String USER_INFO = "userId";

    private final CustomerRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;


    @Value("${spring.jwt.secret}")
    private String secret;

    @Value("${spring.jwt.access-token-validity-in-seconds}")
    private long accessTokenValidityTime;

    @Value("${spring.jwt.refresh-token-validity-in-seconds}")
    private long refreshTokenValidityTime;


    private Key key;

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenInfoResponse createToken(Authentication authentication, boolean isAdditionalInfoProvided, Long userId) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date accessTokenValidity = new Date(now + 1000 * this.accessTokenValidityTime);
        Date refreshTokenValidity = new Date(now + 1000 * this.refreshTokenValidityTime);
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .claim(ADDITIONAL_INFO, isAdditionalInfoProvided) // 추가 정보 입력 여부를 클레임에 추가
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(accessTokenValidity)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(refreshTokenValidity)
                .claim(USER_INFO, userId)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        refreshTokenRepository.save(refreshToken, userId);

        return TokenInfoResponse.from("Bearer", accessToken, refreshToken, refreshTokenValidityTime);

    }

    public boolean getAdditionalInfoProvided(String token){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.get(ADDITIONAL_INFO, Boolean.class);
    }

    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        Customer user = this.userRepository.findByEmailonToken(claims.getSubject())
                .orElseThrow(() -> new BizException(NOT_FOUND_EMAIL));

        return new UsernamePasswordAuthenticationToken(new CustomUserDetails(user), token, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
            throw new BizException(MAL_FORMED_TOKEN);
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
            throw new BizException(EXPIRED_TOKEN);
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
            throw new BizException(UNSUPPORTED_TOKEN);
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
            throw new BizException(ILLEGAL_TOKEN);
        } catch(Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
    public Long getExpiration(String accessToken) {
        Date expiration = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody().getExpiration();
        Long now = new Date().getTime();
        return (expiration.getTime() - now);
    }

    public Long getUserId(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get(USER_INFO,Long.class);
    }

}
