package server.api.insurance.employee.dto;

import lombok.*;
import server.api.insurance.common.util.Constants.Result;
import server.api.insurance.employee.entity.Reward;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RewardDto {
    private int rewardID;
    private int contractID;
    private int rewardAmount;

    private Result appliResult;
    private String accidentProfile;			// File 형식이 TUI에서는 지원되지 않으므로 String으로 대신함
    private LocalDate appliDate;
    private String content;

    private String customerName;
    private String identifyProfile;			// File 형식이 TUI에서는 지원되지 않으므로 String으로 대신함

    public static RewardDto of(Reward reward) {
        return new RewardDto();
    }
    // 보상금

}
