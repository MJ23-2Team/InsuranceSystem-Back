package server.api.insurance.contractManagement;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractManagementPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policyid")
    private int policyID;
    private String content;
    private String name;

    public static ContractManagementPolicy of( ContractManagementPolicyDto contractManagementPolicyDto ){
        return ContractManagementPolicy.builder()
                .policyID( contractManagementPolicyDto.getPolicyID() )
                .content( contractManagementPolicyDto.getContent() )
                .name( contractManagementPolicyDto.getName() )
                .build();
    }
}
