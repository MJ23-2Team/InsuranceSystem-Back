package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.state.ContractRunState;
import server.app.insurance.user.employee.state.ContractState;
import server.app.insurance.user.employee.state.ContractUWState;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {
    private int contractID;
    private int customerID;
    private int insuranceID;

    private LocalDate contractDate;
    private String contractFile;
    private ContractState contractState;
    private ContractRunState contractRunState;
    private ContractUWState contractUWState;
    private String specialization;
}
