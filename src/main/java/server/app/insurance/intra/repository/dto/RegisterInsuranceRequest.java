package server.app.insurance.intra.repository.dto;

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
