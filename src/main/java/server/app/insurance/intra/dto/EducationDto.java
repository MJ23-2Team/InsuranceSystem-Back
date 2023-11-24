package server.app.insurance.intra.dto;

import jakarta.persistence.Id;
import lombok.*;
import server.app.insurance.intra.entity.Education;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    @Id
    private int educationID;
    private int budget;
    private String content;
    private int duration;
    private String exResult;
    private String name;
    private String place;
    private String teacherName;
    private String teacherPhoneNumber;

    public static EducationDto of( Education education ){
        return EducationDto.builder()
                .educationID( education.getEducationID() )
                .budget( education.getBudget() )
                .content( education.getContent() )
                .duration( education.getDuration() )
                .exResult( education.getExResult() )
                .name( education.getName() )
                .place( education.getPlace() )
                .teacherName( education.getTeacherName() )
                .teacherPhoneNumber( education.getTeacherPhoneNumber() )
                .build();
    }
}
