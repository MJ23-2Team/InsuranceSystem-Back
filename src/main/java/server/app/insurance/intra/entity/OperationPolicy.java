package server.app.insurance.intra.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.intra.dto.OperationPolicyRequest;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policyID")
    private int policyID;

    private String name;
    private String content;

    @Builder.Default
    private int rating = 0;
    @Builder.Default
    private int pass= 0;

    public static OperationPolicy of(OperationPolicyRequest dto) {
        return OperationPolicy.builder()
                .content(dto.getContent())
                .name(dto.getName())
                .build();

    }
}
