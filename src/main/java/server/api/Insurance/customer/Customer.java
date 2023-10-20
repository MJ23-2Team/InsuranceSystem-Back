package server.api.insurance.customer;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.contract.AdviceNote;
import server.api.insurance.contract.Contract;
import server.api.insurance.customerManagement.CustomerManagement;
import server.api.insurance.util.Constants.Gender;

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

    @OneToMany(mappedBy = "customer") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<Contract> contracts = new ArrayList<>();
    @OneToMany(mappedBy = "customer") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<AdviceNote> adviceNotes = new ArrayList<>();
    @OneToMany(mappedBy = "customer") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<CustomerCounseling> customerCounselings = new ArrayList<>();
    @OneToMany(mappedBy = "customer") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<CustomerManagement> customerManagements = new ArrayList<>();
}
