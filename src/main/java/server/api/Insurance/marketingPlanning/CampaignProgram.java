package server.api.insurance.marketingPlanning;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampaignProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaignID")
    private Long campaignID; // 캠페인 ID - DB 자동 생성
    private Long insuranceID; // 캠페인 대상 보험

    private int budget; // 캠페인 예산

    private String campaignName; // 캠페인 이름
    private String campaignTarget; // 캠페인 대상
    private int duration; // 캠페인 기간
    private float exResult; // 캠페인 예상 손익률
    private String place; // 캠페인 장소
    private String campaignWay; // 캠페인 수단 - 시나리오에 적혀있지만 설계 과정에서 attribute가 제외되서 추가함
    private float endResult; // 실제 손익률 - 시나리오에 적혀있지만 설계 과정에서 attribute가 제외되서 추가함
    //private CampaignProgram report; // 캠페인 결과 분석 보고서 - 시나리오에 적혀있지만 설계에서 제외됨
    private CampaignState state;
    private String outTeam;

}
