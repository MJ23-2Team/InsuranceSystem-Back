package server.api.insurance.businessEducation;

import lombok.*;
import server.api.insurance.util.Constants.Gender;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationStudentDto {
    private int studentID;
    private int educationID;
    private Gender gender;;
    private int age;
    private String name;
    private String phone;
    private String examination;
    private int studentScore;

    public static EducationStudentDto of( EducationStudent educationStudent ){
        return EducationStudentDto.builder()
                .studentID( educationStudent.getStudentID() )
                .gender( educationStudent.getGender() )
                .age(educationStudent.getAge() )
                .name(educationStudent.getName() )
                .phone( educationStudent.getPhone() )
                .examination( educationStudent.getExamination() )
                .studentScore( educationStudent.getStudentScore() )
                .build();
    }
}
