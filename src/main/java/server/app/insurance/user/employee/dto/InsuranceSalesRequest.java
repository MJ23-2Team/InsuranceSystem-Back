package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.state.InsuranceState;
import server.app.insurance.user.employee.state.InsuranceType;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceSalesRequest {
    private int insuranceID;
    private LocalDate salesStartDate; // 판매 시작일
    private LocalDate salesEndDate; // 판매 종료일
    private int goalPeopleNumber; // 예상 목표 인원
    private String salesMethod; // 판매 방식
}
