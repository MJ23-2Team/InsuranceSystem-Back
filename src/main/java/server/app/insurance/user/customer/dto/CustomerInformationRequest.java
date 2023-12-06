package server.app.insurance.user.customer.dto;

import lombok.*;
import server.app.insurance.common.util.Constants;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInformationRequest {
    private int customerID;
    private String name;
    private int age;
    private Constants.Gender sex;
    private String phoneNumber;
    private int incomeLevel;
    private String accountNumber; //계좌번호
    private String accountPassword;
}
