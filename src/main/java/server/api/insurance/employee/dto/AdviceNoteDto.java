package server.api.insurance.employee.dto;

import lombok.*;
import server.api.insurance.common.util.Constants.Result;
import server.api.insurance.employee.entity.AdviceNote;

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
                .build();
    }
}
