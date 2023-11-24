package server.app.insurance.intra.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import server.app.insurance.common.util.BaseResponseType;

@Getter
@AllArgsConstructor
public enum intraResponseType implements BaseResponseType {
    ESTABLISH_SUCCESS(20001, "정책 건의 완료", HttpStatus.OK),
    MANAGE_SUCCESS(20002, "정책 추천 완료", HttpStatus.OK),
    MAKEOP_SUCCESS(20003, "정책 통과", HttpStatus.OK),
    RETRIVE_SUCCESS(20004, "정책 조회 완료", HttpStatus.OK),
    DOBASIC_SUCCESS(2005, "기본 인수심사 완료" , HttpStatus.OK),
    DOCOLLABORATIVE_SUCCESS(2005, "공동 인수심사 완료", HttpStatus.OK),

    CONNECT_ERROR(40001, "연결 에러", HttpStatus.BAD_REQUEST);
    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
}
