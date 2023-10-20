package server.api.insurance.business;

import jakarta.persistence.*;
import lombok.*;

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
}
