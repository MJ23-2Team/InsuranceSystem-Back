package server.api.insurance.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.employee.dto.CampaignProgramDto;
import server.api.insurance.employee.state.CampaignState;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampaignProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaignid")
    private int campaignID; // 캠페인 ID - DB 자동 생성

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insuranceid")
    private Insurance insurance;

    private int budget; // 캠페인 예산

    private String campaignName; // 캠페인 이름
    private String campaignTarget; // 캠페인 대상
    private int duration; // 캠페인 기간
    private float exResult; // 캠페인 예상 손익률
    private String place; // 캠페인 장소
    private String campaignWay; // 캠페인 수단 - 시나리오에 적혀있지만 설계 과정에서 attribute가 제외되서 추가함
    private float endResult; // 실제 손익률 - 시나리오에 적혀있지만 설계 과정에서 attribute가 제외되서 추가함
    //private CampaignProgram report; // 캠페인 결과 분석 보고서 - 시나리오에 적혀있지만 설계에서 제외됨
    @Enumerated(EnumType.STRING)
    private CampaignState state;
    private String outTeam;

    public static CampaignProgram of(Insurance campaignInsurance, CampaignProgramDto campaignProgramDto) {
        return CampaignProgram.builder()
                .insurance(campaignInsurance)
                .budget(campaignProgramDto.getBudget())
                .campaignName(campaignProgramDto.getCampaignName())
                .campaignTarget(campaignProgramDto.getCampaignTarget())
                .duration(campaignProgramDto.getDuration())
                .exResult(campaignProgramDto.getExResult())
                .place(campaignProgramDto.getPlace())
                .campaignWay(campaignProgramDto.getCampaignWay())
                .state(CampaignState.PLAN)
                .build();
    }
}
