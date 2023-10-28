package server.api.insurance.business.entity;

import jakarta.persistence.*;
import lombok.*;
import server.api.insurance.business.dto.EducationStudentDto;
import server.api.insurance.common.util.Constants.Gender;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private int studentID;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private String name;
    private String phone;
    private String examination;
    private int studentScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "educationID")
    private Education education;

    public static EducationStudent of( EducationStudentDto educationStudentDto ){
        return EducationStudent.builder()
                .studentID( educationStudentDto.getStudentID() )
                .gender( educationStudentDto.getGender() )
                .age(educationStudentDto.getAge() )
                .name(educationStudentDto.getName() )
                .phone( educationStudentDto.getPhone() )
                .examination( educationStudentDto.getExamination() )
                .studentScore( educationStudentDto.getStudentScore() )
                .build();
    }
}
