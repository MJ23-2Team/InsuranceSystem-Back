package server.app.insurance.user.customer.dto;

import lombok.*;
import server.app.insurance.user.customer.state.CounselingState;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCounselingDto {
    private int counselingID;
    private int customerID;
    private String counselingPlace;
    private LocalDateTime counselingTime;
    private CounselingState counselingState;
}
