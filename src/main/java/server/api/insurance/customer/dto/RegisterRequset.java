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
    private String Id;
    private String Pw;
    private CustomerDto customerDto;
}
