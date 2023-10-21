package server.api.insurance.customerManagement;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerManagementDto {
    private int customerManagementID;
    private int customerID;
    private String ID;
    private String PW;
}
