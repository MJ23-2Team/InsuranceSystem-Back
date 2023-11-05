package server.app.insurance.conduct.dto;

import lombok.*;
import server.app.insurance.conduct.entity.ContractManagementPolicy;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractManagementPolicyDto {
    private int policyID;
    private String content;
    private String name;

    public static ContractManagementPolicyDto of( ContractManagementPolicy contractManagementPolicy ){
        return ContractManagementPolicyDto.builder()
                .policyID( contractManagementPolicy.getPolicyID() )
                .content( contractManagementPolicy.getContent() )
                .name( contractManagementPolicy.getName() )
                .build();
    }
}
