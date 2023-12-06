package server.app.insurance.intra.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.intra.dto.EducationDto;
import server.app.insurance.intra.dto.EducationStudentDto;
import server.app.insurance.common.util.Constants;

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
    private Constants.Gender gender;
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

    public static EducationStudent allOf( EducationStudentDto educationStudentDto, EducationDto educationDto ){
        return EducationStudent.builder()
                .studentID( educationStudentDto.getStudentID() )
                .gender( educationStudentDto.getGender() )
                .education( Education.of( educationDto ) )
                .age(educationStudentDto.getAge() )
                .name(educationStudentDto.getName() )
                .phone( educationStudentDto.getPhone() )
                .examination( educationStudentDto.getExamination() )
                .studentScore( educationStudentDto.getStudentScore() )
                .build();
    }
}
