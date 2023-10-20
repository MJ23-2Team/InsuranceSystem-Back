package server.api.insurance.businessEducation;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.util.Constants.Gender;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentID")
    private int studentID;
    private Gender gender;
    private int age;
    private String name;
    private String phone;
    private String examination;
    private int studentScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "educationID")
    private Education educationID;
}
