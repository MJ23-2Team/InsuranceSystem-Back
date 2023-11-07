package server.app.insurance.intra.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.intra.dto.OperationPolicyDto;

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
    private String content;
    private String name;

    private int rating;
    private int pass;

    public static OperationPolicy of(OperationPolicyDto dto) {
        return OperationPolicy.builder()
                .policyID(dto.getPolicyID())
                .content(dto.getContent())
                .name(dto.getName())
                .rating(dto.getRating())
                .pass(dto.getPass())
                .build();

    }
}
