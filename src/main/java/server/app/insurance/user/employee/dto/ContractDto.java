package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.employee.entity.Contract;
import server.app.insurance.user.employee.entity.Insurance;
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

    public ContractDto( int contractID, int customerID, int insuranceID, LocalDate contractDate, String contractFile ){
        this.contractID = contractID;
        this.customerID = customerID;
        this.insuranceID = insuranceID;
        this.contractDate = contractDate;
        this.contractFile = contractFile;
    }

    public static ContractDto of(Contract contract) {
        return ContractDto.builder()
                .contractID(contract.getContractID())
                .customerID(contract.getCustomer().getCustomerID())
                .insuranceID(contract.getInsurance().getInsuranceID())
                .contractRunState(contract.getContractRunState())
                .contractState(contract.getContractState())
                .build();
    }

    public static ContractDto someOf( Contract contract ){
        return ContractDto.builder()
                .contractID( contract.getContractID() )
                .contractDate( contract.getContractDate() )
                .contractFile( contract.getContractFile() )
                .contractState( contract.getContractState() )
                .contractRunState( contract.getContractRunState() )
                .contractUWState( contract.getContractUWState() )
                .specialization( contract.getSpecialization() )
                .build();
    }

}
