package server.api.insurance.businessEducation;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private int educationID;
    private int budget;
    private String content;
    private int duration;
    private String exResult;
    private String name;
    private String place;
    private String teacherName;
    private String teacherPhoneNumber;
}
