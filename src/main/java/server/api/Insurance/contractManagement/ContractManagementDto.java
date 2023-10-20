package server.api.insurance.contractManagement;

import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractManagementDto {
    private int policyID;
    private String content;
    private String name;
}
