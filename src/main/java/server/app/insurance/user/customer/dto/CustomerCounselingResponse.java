package server.app.insurance.user.customer.dto;

import lombok.*;
import server.app.insurance.user.customer.entity.CustomerCounseling;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCounselingResponse {
    private int counselingID;
    private int customerID;
    private String customerName;
    private LocalDate counselingDate;
    private LocalTime counselingTime;

    public static CustomerCounselingResponse of(CustomerCounseling customerCounseling) {
        return CustomerCounselingResponse.builder()
                .counselingID(customerCounseling.getCounselingID())
                .customerID(customerCounseling.getCustomer().getCustomerID())
                .customerName(customerCounseling.getCustomer().getName())
                .counselingDate(customerCounseling.getCounselingTime().toLocalDate())
                .counselingTime(customerCounseling.getCounselingTime().toLocalTime())
                .build();
    }
}
