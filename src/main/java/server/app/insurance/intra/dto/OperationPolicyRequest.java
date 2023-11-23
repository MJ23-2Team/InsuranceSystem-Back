package server.app.insurance.intra.dto;

import lombok.*;
import server.app.insurance.intra.entity.OperationPolicy;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationPolicyRequest {
    private String content;
    private String name;

    public static OperationPolicyRequest of(OperationPolicy dto) {
        return OperationPolicyRequest.builder()
                .content(dto.getContent())
                .name(dto.getName())
                .build();
    }
}
