package server.api.insurance.business.dto;

import lombok.*;
import server.api.insurance.business.entity.Education;

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
