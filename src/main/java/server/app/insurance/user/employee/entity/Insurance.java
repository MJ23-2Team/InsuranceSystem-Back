package server.app.insurance.user.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.state.InsuranceState;
import server.app.insurance.user.employee.state.InsuranceType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insuranceid")
    private int insuranceID;
    private String insuranceName;
    private String planReport;
    @Enumerated(EnumType.STRING)
    private InsuranceState insuranceState;
    @Enumerated(EnumType.STRING)
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

    @OneToMany(mappedBy = "insurance", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<Contract> contracts = new ArrayList<>();
    @OneToMany(mappedBy = "insurance", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<UserPersona> userPersonas = new ArrayList<>();
    @OneToMany(mappedBy = "insurance", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<CampaignProgram> campaignPrograms = new ArrayList<>();

    public static Insurance of(InsuranceDto insuranceDto) {
        return Insurance.builder()
                .insuranceID( insuranceDto.getInsuranceID() )
                .insuranceName( insuranceDto.getInsuranceName() )
                .planReport(insuranceDto.getPlanReport() )
                .insuranceState( insuranceDto.getInsuranceState() )
                .insuranceType( insuranceDto.getInsuranceType() )
                .salesTarget( insuranceDto.getSalesTarget() )
                .canRegistTarget( insuranceDto.getCanRegistTarget() )
                .payment( insuranceDto.getPayment() )
                .guarantee(insuranceDto.getGuarantee() )
                .estimatedDevelopment(insuranceDto.getEstimatedDevelopment() )
                .estimatedProfitRate(insuranceDto.getEstimatedProfitRate() )
                .riskDegree(insuranceDto.getRiskDegree() )
                .salesStartDate(insuranceDto.getSalesStartDate() )
                .salesEndDate(insuranceDto.getSalesEndDate() )
                .goalPeopleNumber(insuranceDto.getGoalPeopleNumber() )
                .salesMethod(insuranceDto.getSalesMethod() )
                .rate(insuranceDto.getRate() )
                .duration(insuranceDto.getDuration() )
                .resultAnalysis(insuranceDto.getResultAnalysis() )
                .rewardAmount(insuranceDto.getRewardAmount() )
                .salesPerformance(insuranceDto.getSalesPerformance() )
                .build();
    }
}
