package server.api.insurance.contract;

import lombok.*;
import server.api.insurance.util.Constants.Result;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdviceNoteDto {
    private int adviceNoteID;
    private String content;
    private int customerID;
    private Result result;
    private int contractID;

    public static AdviceNoteDto of( AdviceNote adviceNote ){
        return AdviceNoteDto.builder()
                .adviceNoteID( adviceNote.getAdviceNoteID() )
                .content( adviceNote.getContent() )
                .result( adviceNote.getResult() )
                .customerID( adviceNote.getCustomerID() )
                .contractID( adviceNote.getContractID() )
                .build();
    }
}
