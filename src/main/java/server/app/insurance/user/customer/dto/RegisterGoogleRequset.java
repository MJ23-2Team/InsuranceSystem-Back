package server.app.insurance.user.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterGoogleRequset {
    private int id;
    private CustomerDto customerDto;
}
