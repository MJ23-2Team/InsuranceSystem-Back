package server.api.insurance.customer.dto;

import lombok.*;
import server.api.insurance.customer.entity.Customer;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto{
    private Long id;
    private String name;
    private int age;

    public static CustomerDto of(Customer user){
        return CustomerDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .build();
    }
}
