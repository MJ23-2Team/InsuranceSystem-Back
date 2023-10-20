package server.api.insurance.customerManagement;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.customer.Customer;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;
    private String ID;
    private String PW;
}
