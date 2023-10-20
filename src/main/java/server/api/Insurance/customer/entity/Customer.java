package server.api.insurance.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.global.Constants;
import server.api.insurance.global.Constants.Gender;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerID")
    private int customerID;

    private String address;
    private int age;
    private Gender sex;
    private String job;
    private String name;
    private String phoneNumber;
    private String registrationNumber;
    private int incomeLevel;
    private String accountNumber; //계좌번호
    private String accountPassword;
}
