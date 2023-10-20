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
    @Column(name = "contractID")
    private int contractID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insuranceID")
    private Insurance insurance;

    private LocalDate contractDate;
    private String contractFile;
    private ContractState contractState;
    private ContractRunState contractRunState;
    private ContractUWState contractUWState;
    private String specialization;

    @OneToMany(mappedBy = "contract") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<AdviceNote> adviceNotes = new ArrayList<>();
    @OneToMany(mappedBy = "contract") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<Reward> rewards = new ArrayList<>();
    @OneToMany(mappedBy = "contract") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<Payment> payments = new ArrayList<>();
}
