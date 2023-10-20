package server.api.insurance.contract;

import jakarta.persistence.*;
import lombok.*;
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
    @Column(name = "adviceNoteID")
    private int adviceNoteID;
    private String content;
    private int customerID;
    private Result result;
    private int contractID;
}
