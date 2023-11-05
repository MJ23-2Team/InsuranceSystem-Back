package server.app.insurance.conduct.dto;

import lombok.*;
import server.app.insurance.conduct.entity.OperationPolicy;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationPolicyDto {
    private int policyID;
    private String content;
    private String name;
    private int rating;
    private int pass;

    public static OperationPolicyDto of(OperationPolicy dto) {
        return OperationPolicyDto.builder()
                .policyID(dto.getPolicyID())
                .content(dto.getContent())
                .name(dto.getName())
                .rating(dto.getRating())
                .pass(dto.getPass())
                .build();
    }
}
