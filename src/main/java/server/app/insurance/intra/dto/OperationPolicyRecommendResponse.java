package server.app.insurance.intra.dto;

import lombok.*;
import server.app.insurance.intra.entity.OperationPolicy;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationPolicyRecommendResponse {
    private String content;
    private String name;

    public static OperationPolicyRecommendResponse of(OperationPolicy dto) {
        return OperationPolicyRecommendResponse.builder()
                .name(dto.getName())
                .content(dto.getContent())
                .build();
    }
}
