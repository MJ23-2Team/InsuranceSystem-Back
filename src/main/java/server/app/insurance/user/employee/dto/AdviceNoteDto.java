package server.app.insurance.user.employee.dto;

import lombok.*;
import server.app.insurance.user.employee.entity.AdviceNote;
import server.app.insurance.common.util.Constants;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdviceNoteDto {
    private int adviceNoteID;
    private String content;
    private int customerID;
    private Constants.Result result;
    private int contractID;

    public static AdviceNoteDto of( AdviceNote adviceNote ){
        return AdviceNoteDto.builder()
                .adviceNoteID( adviceNote.getAdviceNoteID() )
                .content( adviceNote.getContent() )
                .result( adviceNote.getResult() )
                .build();
    }
}
