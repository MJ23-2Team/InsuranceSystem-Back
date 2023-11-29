package server.app.insurance.intra.dto;

import lombok.*;
import server.app.insurance.intra.entity.OperationPolicy;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationPolicyResponse {
    private int policyID;
    private String content;
    private String name;
    private int rating;
    private int pass;

    public static OperationPolicyResponse of(OperationPolicy dto) {
        return OperationPolicyResponse.builder()
                .policyID(dto.getPolicyId())
                .name(dto.getName())
                .content(dto.getContent())
                .rating(dto.getRating())
                .pass(dto.getPass())
                .build();
    }
}
