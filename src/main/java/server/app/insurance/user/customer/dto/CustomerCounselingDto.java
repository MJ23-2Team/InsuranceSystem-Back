package server.app.insurance.user.customer.dto;

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

    public CustomerCounselingDto(int counselingID, String counselingPlace, LocalDateTime counselingTime) {
        this.counselingID = counselingID;
        this.counselingPlace = counselingPlace;
        this.counselingTime = counselingTime;
    }

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
