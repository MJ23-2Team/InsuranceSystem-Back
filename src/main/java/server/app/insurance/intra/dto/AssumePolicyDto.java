package server.app.insurance.intra.dto;

import lombok.*;
import server.app.insurance.intra.entity.AssumePolicy;
import server.app.insurance.intra.state.PolicyType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssumePolicyDto {
    private int policyID; // 인수정책 ID - DB에서 자동 추가
    private String name; // 인수정책 이름
    private String content; // 인수정책 내용
    private PolicyType policyType; // 인수정책의 종류(일반 인수, 공동 인수) - 시나리오에 존재하지만 설계에서 attribute 제외되어 추가함

    public static AssumePolicyDto of(AssumePolicy assumePolicy) {
        return AssumePolicyDto.builder()
                .policyID(assumePolicy.getPolicyID())
                .name(assumePolicy.getName())
                .content(assumePolicy.getContent())
                .policyType(assumePolicy.getPolicyType())
                .build();
    }
}
