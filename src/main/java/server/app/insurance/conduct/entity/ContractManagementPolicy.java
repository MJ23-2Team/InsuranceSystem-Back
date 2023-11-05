package server.app.insurance.conduct.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.conduct.dto.ContractManagementPolicyDto;

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
