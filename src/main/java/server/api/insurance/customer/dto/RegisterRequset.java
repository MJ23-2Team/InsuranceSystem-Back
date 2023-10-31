package server.api.insurance.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.api.insurance.customer.dto.CustomerDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequset {
    private String id;
    private String pw;
    private CustomerDto customerDto;
}
