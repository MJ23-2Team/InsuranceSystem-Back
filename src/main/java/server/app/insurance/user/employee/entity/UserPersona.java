package server.app.insurance.user.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.common.util.Constants;
import server.app.insurance.user.employee.dto.UserPersonaDto;

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

    public static UserPersona of(UserPersonaDto userPersonaDto) {
        return UserPersona.builder()
                .userPersonaID(userPersonaDto.getUserPersonaID())
                .insurance(userPersonaDto.getInsurance())
                .sex(userPersonaDto.getSex())
                .age(userPersonaDto.getAge())
                .job(userPersonaDto.getJob())
                .incomeLevel(userPersonaDto.getIncomeLevel())
                .build();
    }
}
