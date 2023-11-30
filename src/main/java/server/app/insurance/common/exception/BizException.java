package server.app.insurance.common.exception;

import lombok.Getter;
import server.app.insurance.common.util.BaseResponseType;

@Getter
public class BizException extends RuntimeException{
    private final BaseResponseType baseExceptionType;

    public BizException(BaseResponseType baseExceptionType){
        super(baseExceptionType.getMessage());
        this.baseExceptionType = baseExceptionType;
    }

}
