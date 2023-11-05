package server.app.insurance.user.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.user.customer.state.CounselingState;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCounseling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counselingid")
    private int counselingID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private Customer customer;

    private String counselingPlace;
    private LocalDateTime counselingTime;
    @Enumerated(EnumType.STRING)
    private CounselingState counselingState;
}
