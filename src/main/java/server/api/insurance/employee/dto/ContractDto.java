package server.api.insurance.employee.dto;

import lombok.*;
import server.api.insurance.employee.state.ContractRunState;
import server.api.insurance.employee.state.ContractState;
import server.api.insurance.employee.state.ContractUWState;

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
