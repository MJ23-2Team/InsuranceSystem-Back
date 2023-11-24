package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.entity.Insurance;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceRiskRequest {
    private int insuranceID;
    private int riskDegree; // 위험도

    public static InsuranceRiskRequest of(Insurance insurance) {
        return InsuranceRiskRequest.builder()
                .insuranceID(insurance.getInsuranceID())
                .riskDegree(insurance.getRiskDegree())
                .build();

    }
}
