package server.app.insurance.intra.dto;

import lombok.*;
import server.app.insurance.intra.entity.OperationPolicy;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationPolicyRecommandResponse {
    private String content;
    private String name;

    public static OperationPolicyRecommandResponse of(OperationPolicy dto) {
        return OperationPolicyRecommandResponse.builder()
                .name(dto.getName())
                .content(dto.getContent())
                .build();
    }
}
