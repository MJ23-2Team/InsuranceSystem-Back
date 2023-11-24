package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.entity.Insurance;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceProfitRequest {
    private int insuranceID;
    private float estimatedProfitRate; // 예상 손익률

    public static InsuranceProfitRequest of(Insurance insurance) {
        return InsuranceProfitRequest.builder()
                .insuranceID(insurance.getInsuranceID())
                .estimatedProfitRate(insurance.getRate())
                .build();

    }
}
