package server.app.insurance.user.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private Long userId;
    private String process;

    public static LoginResponse from(TokenInfoResponse tokenInfoResponse, String process, Long userId) {
        return LoginResponse.builder()
                .accessToken(tokenInfoResponse.getAccessToken())
                .refreshToken(tokenInfoResponse.getRefreshToken())
                .process(process)
                .userId(userId)
                .build();
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class TokenInfoResponse {
        private String grantType;
        private String accessToken;
        private String refreshToken;
        private Long refreshTokenExpirationTime;

        public static TokenInfoResponse from(String grantType, String accessToken, String refreshToken, Long refreshTokenExpirationTime) {
            return TokenInfoResponse.builder()
                    .grantType(grantType)
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .refreshTokenExpirationTime(refreshTokenExpirationTime)
                    .build();
        }
    }
}
