package server.app.insurance.user.customer.entity;


import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.user.employee.entity.AdviceNote;
import server.app.insurance.user.employee.entity.Contract;
import server.app.insurance.intra.repository.dto.CustomerDto;
import server.app.insurance.common.util.Constants;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private int customerID;

    private String email;
    private String address;
    private int age;
    @Enumerated(EnumType.STRING)
    private Constants.Gender sex;
    private String job;
    private String name;
    private String phoneNumber;
    private String registrationNumber;
    private int incomeLevel;
    private String accountNumber; //계좌번호
    private String accountPassword;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<Contract> contracts = new ArrayList<>();
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<AdviceNote> adviceNotes = new ArrayList<>();
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<CustomerCounseling> customerCounselings = new ArrayList<>();
    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) //FK가 없는 쪽에 mappedBy 사용을 추천
    private CustomerManagement customerManagements = new CustomerManagement();

    public static Customer of(CustomerDto customerDto){
        return Customer.builder()
                .address(customerDto.getAddress())
                .age(customerDto.getAge())
                .sex(customerDto.getSex())
                .job(customerDto.getJob())
                .name(customerDto.getName())
                .phoneNumber(customerDto.getPhoneNumber())
                .registrationNumber(customerDto.getRegistrationNumber())
                .incomeLevel(customerDto.getIncomeLevel())
                .accountNumber(customerDto.getAccountNumber())
                .accountPassword(customerDto.getAccountPassword())
                .build();
    }
}
