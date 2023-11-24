package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.state.InsuranceType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDesignRequest {
    private int insuranceID;
    private String insuranceName;
    private InsuranceType insuranceType;
    private String salesTarget; // 보험 판매 대상
    private String canRegistTarget; // 보험 가입 가능 대상
    private int payment; // 보험료
    private String guarantee; // 보장 내용
    private int estimatedDevelopment; // 개발 예상 비용

    public static InsuranceDesignRequest of(Insurance insurance) {
        return InsuranceDesignRequest.builder()
                .insuranceID(insurance.getInsuranceID())
                .insuranceName(insurance.getInsuranceName())
                .insuranceType(insurance.getInsuranceType())
                .salesTarget(insurance.getSalesTarget())
                .canRegistTarget(insurance.getCanRegistTarget())
                .payment(insurance.getPayment())
                .guarantee(insurance.getGuarantee())
                .estimatedDevelopment(insurance.getEstimatedDevelopment())
                .build();

    }
}
