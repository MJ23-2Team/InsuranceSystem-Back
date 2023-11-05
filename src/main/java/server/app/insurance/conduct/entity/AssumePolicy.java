package server.app.insurance.conduct.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.conduct.dto.AssumePolicyDto;
import server.app.insurance.conduct.state.PolicyType;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssumePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policyid")
    private int policyID; // 인수정책 ID - DB에서 자동 추가
    private String name; // 인수정책 이름
    private String content; // 인수정책 내용
    @Enumerated(EnumType.STRING)
    private PolicyType policyType; // 인수정책의 종류(일반 인수, 공동 인수) - 시나리오에 존재하지만 설계에서 attribute 제외되어 추가함

    public static AssumePolicy of(AssumePolicyDto assumePolicyDto){
        return AssumePolicy.builder()
                .name(assumePolicyDto.getName())
                .content(assumePolicyDto.getContent())
                .policyType(assumePolicyDto.getPolicyType())
                .build();
    }

}
