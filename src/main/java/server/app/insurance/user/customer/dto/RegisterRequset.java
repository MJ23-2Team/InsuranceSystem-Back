package server.app.insurance.user.customer.dto;

import lombok.*;
import server.app.insurance.user.customer.state.UserState;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequset {
    private int id;
    private UserState role;
    private CustomerDto customerDto;
}
