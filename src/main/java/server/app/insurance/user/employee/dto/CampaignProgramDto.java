package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.entity.CampaignProgram;
import server.app.insurance.user.employee.state.CampaignState;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampaignProgramDto {
    private int campaignID; // 캠페인 ID - DB 자동 생성
    private int insuranceID; // 캠페인 대상 보험

    private int budget; // 캠페인 예산

    private String campaignName; // 캠페인 이름
    private String campaignTarget; // 캠페인 대상
    private int duration; // 캠페인 기간
    private float exResult; // 캠페인 예상 손익률
    private String place; // 캠페인 장소
    private String campaignWay; // 캠페인 수단 - 시나리오에 적혀있지만 설계 과정에서 attribute가 제외되서 추가함
    private float endResult; // 실제 손익률 - 시나리오에 적혀있지만 설계 과정에서 attribute가 제외되서 추가함
    private CampaignState state;
    private String outTeam;

    public static CampaignProgramDto of(CampaignProgram campaignProgram) {
        return CampaignProgramDto.builder()
                .insuranceID(campaignProgram.getInsurance().getInsuranceID())
                .campaignID(campaignProgram.getCampaignID())
                .campaignName(campaignProgram.getCampaignName())
                .campaignTarget(campaignProgram.getCampaignTarget())
                .budget(campaignProgram.getBudget())
                .duration(campaignProgram.getDuration())
                .exResult(campaignProgram.getExResult())
                .place(campaignProgram.getPlace())
                .campaignWay(campaignProgram.getCampaignWay())
                .state(campaignProgram.getState())
                .outTeam(campaignProgram.getOutTeam())
                .build();
    }

}
