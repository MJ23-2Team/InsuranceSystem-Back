package server.app.insurance.common.util;

import org.springframework.http.HttpStatus;

public interface BaseResponseType {
    Integer getCode();
    String getMessage();
    HttpStatus getHttpStatus();
}
