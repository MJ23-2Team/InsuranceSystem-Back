package server.app.insurance.user.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.dto.CampaignProgramPlanRequest;
import server.app.insurance.user.employee.state.CampaignState;
import static server.app.insurance.user.outerActor.OuterActor.OUT_TEAM;

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
    public float END_RESULT; // 실제 손익률 - 시나리오에 적혀있지만 설계 과정에서 attribute가 제외되서 추가함

    @Enumerated(EnumType.STRING)
    private CampaignState state;
    private String outTeam;

    public static CampaignProgram of(Insurance campaignInsurance, CampaignProgramPlanRequest campaignProgramDto) {
        return CampaignProgram.builder()
                .insurance(campaignInsurance)
                .campaignName(campaignProgramDto.getCampaignName())
                .campaignTarget(campaignProgramDto.getCampaignTarget())
                .budget(campaignProgramDto.getBudget())
                .duration(campaignProgramDto.getDuration())
                .exResult(campaignProgramDto.getExResult())
                .place(campaignProgramDto.getPlace())
                .campaignWay(campaignProgramDto.getCampaignWay())
                .state(campaignProgramDto.getState())
                .END_RESULT(campaignProgramDto.getEndResult())
                .outTeam(OUT_TEAM)
                .build();
    }
}
