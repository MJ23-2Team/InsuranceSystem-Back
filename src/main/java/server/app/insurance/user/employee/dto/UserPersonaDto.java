package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.common.util.Constants;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPersonaDto {
    private int userPersonaID;
    private int insuranceID;
    private Constants.Gender sex;
    private int age;
    private String job;
    private int incomeLevel;
}
