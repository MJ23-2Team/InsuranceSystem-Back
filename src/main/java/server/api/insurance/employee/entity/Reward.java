package server.api.insurance.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.common.util.Constants.Result;
import server.api.insurance.employee.dto.RewardDto;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractid")
    private Contract contract;
    private int rewardAmount;

    private Result appliResult;
    private String accidentProfile;			// File 형식이 TUI에서는 지원되지 않으므로 String으로 대신함
    private LocalDate appliDate;
    private String content;

    private String customerName;
    private String identifyProfile;			// File 형식이 TUI에서는 지원되지 않으므로 String으로 대신함

    public static Reward of(RewardDto request) {
        return new Reward();
    }
    // 보상금

}
