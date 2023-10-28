package server.api.insurance.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.customer.entity.Customer;
import server.api.insurance.common.util.Constants.Result;
import server.api.insurance.employee.dto.AdviceNoteDto;

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

    @Enumerated(EnumType.STRING)
    private Result result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractid")
    private Contract contract;

    public static AdviceNote of( AdviceNoteDto adviceNoteDto ){
        return AdviceNote.builder()
                .adviceNoteID( adviceNoteDto.getAdviceNoteID() )
                .content( adviceNoteDto.getContent() )
                .result( adviceNoteDto.getResult() )
                .build();
    }
}
