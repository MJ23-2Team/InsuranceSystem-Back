package server.api.insurance.reward;

import lombok.*;
import server.api.insurance.util.Constants.Result;

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
					// 보상금

}
