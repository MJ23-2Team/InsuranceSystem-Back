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
}
