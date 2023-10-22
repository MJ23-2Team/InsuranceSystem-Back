package server.api.insurance.reward;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.contract.Contract;
import server.api.insurance.util.Constants.Result;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rewardid")
    private int rewardID;

    @JoinColumn(name = "contractid")
    private int contractID;
    private int rewardAmount;

    private Result appliResult;
    private String accidentProfile;			// File 형식이 TUI에서는 지원되지 않으므로 String으로 대신함
    private LocalDate appliDate;
    private String content;

    private String customerName;
    private String identifyProfile;			// File 형식이 TUI에서는 지원되지 않으므로 String으로 대신함

    public static Reward of( RewardDto rewardDto ){
        return Reward.builder()
                .rewardID( rewardDto.getRewardID() )
                .contractID( rewardDto.getContractID() )
                .rewardAmount( rewardDto.getRewardAmount() )
                .appliResult( rewardDto.getAppliResult() )
                .appliDate( rewardDto.getAppliDate() )
                .content( rewardDto.getContent() )
                .customerName( rewardDto.getCustomerName() )
                .identifyProfile( rewardDto.getIdentifyProfile() )
                .build();
    }					// 보상금

}
