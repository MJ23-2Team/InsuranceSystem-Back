package server.app.insurance.user.customer.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInsuranceRequest {
        private int insuranceID;
        private int customerID;
}
