package server.api.insurance.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.customer.entity.Customer;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_managementid")
    private int customerManagementID;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private Customer customer;
    private String ID;
    private String PW;
}
