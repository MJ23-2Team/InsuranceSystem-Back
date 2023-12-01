package server.app.insurance.user.customer.dto;

import lombok.*;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.common.util.Constants;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto{

    private int customerID;
    private String address;
    private int age;
    private Constants.Gender sex;
    private String job;
    private String name;
    private String phoneNumber;
    private String registrationNumber;
    private int incomeLevel;
    private String accountNumber; //계좌번호
    private String accountPassword;


    public static CustomerDto of(Customer customer){
        return CustomerDto.builder()
                .customerID(customer.getCustomerID())
                .address(customer.getAddress())
                .age(customer.getAge())
                .sex(customer.getSex())
                .job(customer.getJob())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .registrationNumber(customer.getRegistrationNumber())
                .incomeLevel(customer.getIncomeLevel())
                .accountNumber(customer.getAccountNumber())
                .accountPassword(customer.getAccountPassword())
                .build();
    }
}
