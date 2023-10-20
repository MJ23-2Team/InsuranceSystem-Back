package server.api.insurance.customer;

import jakarta.persistence.*;
import lombok.*;

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
