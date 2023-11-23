package server.app.insurance.intra.dto;

import lombok.*;
import server.app.insurance.intra.entity.OperationPolicy;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationPolicyManageRequest {
    private int id;
}
