package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.entity.Reward;
import server.app.insurance.common.util.Constants;

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

    private Constants.Result appliResult;
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
