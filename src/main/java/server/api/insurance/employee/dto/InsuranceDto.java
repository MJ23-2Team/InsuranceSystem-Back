package server.api.insurance.employee.dto;

import lombok.*;
import server.api.insurance.employee.entity.Insurance;
import server.api.insurance.employee.state.InsuranceState;
import server.api.insurance.employee.state.InsuranceType;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDto {
    private int insuranceID;
    private String insuranceName;
    private String planReport;
    private InsuranceState insuranceState;
    private InsuranceType insuranceType;
    private String salesTarget; // 보험 판매 대상
    private String canRegistTarget; // 보험 가입 가능 대상
    private int payment; // 보험료
    private String guarantee; // 보장 내용
    private int estimatedDevelopment; // 개발 예상 비용
    private float estimatedProfitRate; // 예상 손익률
    private int riskDegree; // 위험도
    private LocalDate salesStartDate; // 판매 시작일
    private LocalDate salesEndDate; // 판매 종료일
    private int goalPeopleNumber; // 예상 목표 인원
    private String salesMethod; // 판매 방식

    private float rate; // 보험요율
    private int duration;	// 기간
    private int resultAnalysis;	// 결과 분석
    private int rewardAmount;	// 보상 금액
    private int salesPerformance;	// 판매 실적

    public static InsuranceDto of(Insurance insurance) {
        return InsuranceDto.builder()
                .insuranceID(insurance.getInsuranceID())
                .insuranceName(insurance.getInsuranceName())
                .planReport(insurance.getPlanReport())
                .insuranceState(insurance.getInsuranceState())
                .insuranceType(insurance.getInsuranceType())
                .salesTarget(insurance.getSalesTarget())
                .canRegistTarget(insurance.getCanRegistTarget())
                .payment(insurance.getPayment())
                .guarantee(insurance.getGuarantee())
                .estimatedDevelopment(insurance.getEstimatedDevelopment())
                .estimatedProfitRate(insurance.getEstimatedProfitRate())
                .riskDegree(insurance.getRiskDegree())
                .salesStartDate(insurance.getSalesStartDate())
                .salesEndDate(insurance.getSalesEndDate())
                .goalPeopleNumber(insurance.getGoalPeopleNumber())
                .salesMethod(insurance.getSalesMethod())
                .rate(insurance.getRate())
                .duration(insurance.getDuration())
                .resultAnalysis(insurance.getResultAnalysis())
                .rewardAmount(insurance.getRewardAmount())
                .salesPerformance(insurance.getSalesPerformance())
                .build();

    }
}
