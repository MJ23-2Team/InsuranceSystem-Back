package server.api.insurance.contract;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.customer.Customer;
import server.api.insurance.util.Constants.Result;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdviceNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adviceNoteid")
    private int adviceNoteID;
    private String content;
    private Result result;

    @JoinColumn(name = "customerID")
    private int customerID;

    @JoinColumn(name = "contractID")
    private int contractID;

    public static AdviceNote of( AdviceNoteDto adviceNoteDto ){
        return AdviceNote.builder()
                .adviceNoteID( adviceNoteDto.getAdviceNoteID() )
                .content( adviceNoteDto.getContent() )
                .result( adviceNoteDto.getResult() )
                .customerID( adviceNoteDto.getCustomerID() )
                .contractID( adviceNoteDto.getContractID() )
                .build();
    }
}
