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
    @Column(name = "customer_managementid")
    private int customerManagementID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private Customer customer;
    private String ID;
    private String PW;

    public static CustomerManagement of(CustomerManagementDto dto){
        return CustomerManagement.builder().build();
    }
}
