package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.entity.Insurance;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsurancePlanRequest {
    private int insuranceID;
    private String planReport;

    public static InsurancePlanRequest of(Insurance insurance) {
        return InsurancePlanRequest.builder()
                .insuranceID(insurance.getInsuranceID())
                .planReport(insurance.getPlanReport())
                .build();

    }
}
