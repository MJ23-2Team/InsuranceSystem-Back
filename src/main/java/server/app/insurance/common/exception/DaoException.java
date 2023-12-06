package server.app.insurance.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import server.app.insurance.common.util.BaseResponseType;

public class DaoException extends CustomException{

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    @Getter
    @AllArgsConstructor
    public enum CustomerResponseException implements BaseResponseType {
        CONNECT_ERROR(40001, "연결 에러", HttpStatus.BAD_REQUEST),
        NOT_FOUND_EMAIL(40002,"이메일을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
        EXISTED_NICKNAME(40003, "이미 존재하는 닉네임입니다", HttpStatus.BAD_REQUEST),
        NOT_LOGGED_IN_USER(40004, "사용자 정보를 알 수 없습니다.", HttpStatus.BAD_REQUEST);
        private final Integer code;
        private final String message;
        private final HttpStatus httpStatus;
    }
}
