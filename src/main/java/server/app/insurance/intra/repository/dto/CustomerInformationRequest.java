package server.app.insurance.intra.repository.dto;

import lombok.*;
import server.app.insurance.common.util.Constants;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInformationRequest {
    private int age;
    private Constants.Gender sex;
    private String name;
    private String phoneNumber;
    private String registrationNumber;
    private int incomeLevel;
    private String accountNumber; //계좌번호
    private String accountPassword;
}
