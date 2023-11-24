package server.app.insurance.user.customer.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import server.app.insurance.common.util.BaseResponseType;

@Getter
@AllArgsConstructor
public enum CustomerResponseType implements BaseResponseType {
    REGIST_SUCCESS(20001, "회원가입 성공", HttpStatus.OK),
    LOGIN_SUCCESS(20002, "로그인 성공", HttpStatus.OK),
    RETRIVE_SUCCESS(20002, "고객 정보 불러오기 성공", HttpStatus.OK),
    REGIST_INSURANCE_SUCCESS(20003, "보험 가입 신청 성공", HttpStatus.OK),


    CONNECT_ERROR(40001, "연결 에러", HttpStatus.BAD_REQUEST),
    NOT_FOUND_EMAIL(40002,"이메일을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    EXISTED_NICKNAME(40003, "이미 존재하는 닉네임입니다", HttpStatus.BAD_REQUEST),
    NOT_LOGGED_IN_USER(40004, "사용자 정보를 알 수 없습니다.", HttpStatus.BAD_REQUEST);
    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
}
