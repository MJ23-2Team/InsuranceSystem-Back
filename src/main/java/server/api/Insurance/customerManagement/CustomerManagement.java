package server.api.insurance.customerManagement;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerManagementID")
    private int customerManagementID;
    private int customerID;
    private String ID;
    private String PW;
}
