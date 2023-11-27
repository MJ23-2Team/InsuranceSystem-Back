package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.common.util.Constants;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.entity.UserPersona;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPersonaDto {
    private int userPersonaID;
    private Insurance insurance;
    private Constants.Gender sex;
    private int age;
    private String job;
    private int incomeLevel;

    public static UserPersonaDto of(UserPersona userPersona) {
        return UserPersonaDto.builder()
                .userPersonaID(userPersona.getUserPersonaID())
                .insurance(userPersona.getInsurance())
                .sex(userPersona.getSex())
                .age(userPersona.getAge())
                .job(userPersona.getJob())
                .incomeLevel(userPersona.getIncomeLevel())
                .build();
    }
}
