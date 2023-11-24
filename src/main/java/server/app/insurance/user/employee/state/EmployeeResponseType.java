package server.app.insurance.user.employee.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import server.app.insurance.common.util.BaseResponseType;

@Getter
@AllArgsConstructor
public enum EmployeeResponseType implements BaseResponseType {

    CAMPAIGNPLAN_SUCCESS(20001, "캠페인 기획 성공",HttpStatus.OK),
    SETCAMPAIGNRUN_SUCCESS(2002, "캠페인 실행 성공", HttpStatus.OK),
    SETCAMPAIGNRESULT_SUCCESS(2002, "캠페인 결과 저장 성공", HttpStatus.OK),
    RETRIEVERUNCAMPAIGN_SUCCESS(2003, "실행 중인 캠페인 조회 성공", HttpStatus.OK),
    RETRIEVEENDCAMPAIGN_SUCCESS(2003, "종료한 캠페인 조회 성공", HttpStatus.OK);


    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
}
