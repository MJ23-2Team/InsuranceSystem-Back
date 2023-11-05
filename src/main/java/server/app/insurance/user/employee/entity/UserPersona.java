package server.app.insurance.user.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.common.util.Constants;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userPersonaid")
    private int userPersonaID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insuranceid")
    private Insurance insurance;
    @Enumerated(EnumType.STRING)
    private Constants.Gender sex;
    private int age;
    private String job;
    private int incomeLevel;
}
