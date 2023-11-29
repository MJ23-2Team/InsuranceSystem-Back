package server.app.insurance.intra.repository.dto;

import lombok.*;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.customer.entity.CustomerCounseling;
import server.app.insurance.user.customer.state.CounselingState;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCounselingDto {
    private int counselingID;
    private Customer customer;
    private String counselingPlace;
    private LocalDateTime counselingTime;
    private CounselingState counselingState;

    public static CustomerCounselingDto of(CustomerCounseling customerCounseling) {
        return CustomerCounselingDto.builder()
                .counselingID(customerCounseling.getCounselingID())
                .customer(customerCounseling.getCustomer())
                .counselingPlace(customerCounseling.getCounselingPlace())
                .counselingTime(customerCounseling.getCounselingTime())
                .counselingState(customerCounseling.getCounselingState())
                .build();
    }
}
