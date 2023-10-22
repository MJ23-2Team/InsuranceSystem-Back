package server.api.insurance.contract;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.customer.Customer;
import server.api.insurance.util.Constants.Result;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdviceNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adviceNoteid")
    private int adviceNoteID;
    private String content;

    @Enumerated(EnumType.STRING)
    private Result result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractID")
    private Contract contract;
}
