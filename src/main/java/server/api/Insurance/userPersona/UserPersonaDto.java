package server.api.insurance.userPersona;

import lombok.*;
import server.api.insurance.util.Constants.Gender;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPersonaDto {
    private int userPersonaID;
    private int insuranceID;
    private Gender sex;
    private int age;
    private String job;
    private int incomeLevel;
}
