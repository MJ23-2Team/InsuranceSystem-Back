package server.app.insurance.intra.dto;

import lombok.*;
import server.app.insurance.intra.entity.AssumePolicy;
import server.app.insurance.intra.state.PolicyType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssumePolicyRetrieveResponse {

    private int policyID;
    private String name;
    private String content;
    private PolicyType policyType;

    public static AssumePolicyRetrieveResponse of(AssumePolicy assumePolicy) {
        return AssumePolicyRetrieveResponse.builder()
                .policyID(assumePolicy.getPolicyID())
                .name(assumePolicy.getName())
                .content(assumePolicy.getContent())
                .policyType(assumePolicy.getPolicyType())
                .build();
    }
}
