package server.app.insurance.user.customer.dto;

import lombok.*;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.customer.entity.CustomerCounseling;
import server.app.insurance.user.customer.state.CounselingState;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCounselingRequest {
    private int customerID;
    private String counselingPlace;
    private LocalDate counselingDate;
    private LocalTime counselingTime;
}
