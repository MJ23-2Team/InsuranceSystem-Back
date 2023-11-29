package server.app.insurance.intra.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateResultRequest {
    private int sellGruopID;
    private String info;
}
