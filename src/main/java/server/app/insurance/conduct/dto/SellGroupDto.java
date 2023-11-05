package server.app.insurance.conduct.dto;

import lombok.*;
import server.app.insurance.conduct.entity.SellGroup;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellGroupDto {
    private int sellGroupID;
    private String exResult;
    private String name;
    private String representative;
    private String representativePhoneNumber;

    public static SellGroupDto of(SellGroup sellGroup) {
        return SellGroupDto.builder()
                .sellGroupID(sellGroup.getSellGroupID())
                .exResult(sellGroup.getExResult())
                .name(sellGroup.getName())
                .representative(sellGroup.getRepresentative())
                .representativePhoneNumber(sellGroup.getRepresentativePhoneNumber())
                .build();
    }
}
