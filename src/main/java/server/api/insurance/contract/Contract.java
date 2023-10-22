package server.api.insurance.contract;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.customer.Customer;
import server.api.insurance.insurance.Insurance;
import server.api.insurance.reward.Reward;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractid")
    private int contractID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insuranceid")
    private Insurance insurance;

    private LocalDate contractDate;
    private String contractFile;
    @Enumerated(EnumType.STRING)
    private ContractState contractState;
    @Enumerated(EnumType.STRING)
    private ContractRunState contractRunState;
    @Enumerated(EnumType.STRING)
    private ContractUWState contractUWState;
    private String specialization;

    @OneToMany(mappedBy = "contract") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<AdviceNote> adviceNotes = new ArrayList<>();
    @OneToMany(mappedBy = "contract") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<Reward> rewards = new ArrayList<>();
    @OneToMany(mappedBy = "contract") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<Payment> payments = new ArrayList<>();

    public static Contract of(ContractDto contractDto, Customer contractCustomer, Insurance contractInsurance){
        return Contract.builder()
                .customer(contractCustomer)
                .insurance(contractInsurance)
                .contractDate(contractDto.getContractDate())
                .contractFile(contractDto.getContractFile())
                .contractState(ContractState.ONLINE)
                .contractRunState(ContractRunState.READY)
                .contractUWState(ContractUWState.BASIC)
                .specialization(contractDto.getSpecialization())
                .build();
    }
}
