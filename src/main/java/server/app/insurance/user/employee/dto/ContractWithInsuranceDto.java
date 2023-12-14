package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.employee.entity.Contract;
import server.app.insurance.user.employee.entity.Insurance;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractWithInsuranceDto {
    private int contractID;
    private int insuranceID;
    private String insuranceName;
    private int rewardAmount;

    public static ContractWithInsuranceDto of (Contract contract, Insurance insurance ){
        return ContractWithInsuranceDto.builder()
                .contractID( contract.getContractID() )
                .insuranceID( insurance.getInsuranceID() )
                .insuranceName( insurance.getInsuranceName() )
                .rewardAmount( insurance.getRewardAmount() )
                .build();
    }
}
