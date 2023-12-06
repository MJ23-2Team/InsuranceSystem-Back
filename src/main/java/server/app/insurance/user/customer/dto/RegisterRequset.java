package server.app.insurance.user.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.app.insurance.user.customer.state.UserState;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequset {
    private int id;
    private UserState role;
    private CustomerDto customerDto;
}
