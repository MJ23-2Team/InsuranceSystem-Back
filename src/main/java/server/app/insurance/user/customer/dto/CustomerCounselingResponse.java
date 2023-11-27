package server.app.insurance.user.customer.dto;

import lombok.*;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.customer.entity.CustomerCounseling;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCounselingResponse {
    private int counselingID;
    private int customerID;
    private String customerName;

    public static CustomerCounselingResponse of(CustomerCounseling customerCounseling) {
        return CustomerCounselingResponse.builder()
                .counselingID(customerCounseling.getCounselingID())
                .customerID(customerCounseling.getCustomer().getCustomerID())
                .customerName(customerCounseling.getCustomer().getName())
                .build();
    }
}
