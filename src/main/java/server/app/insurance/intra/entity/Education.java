package server.app.insurance.intra.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.intra.dto.EducationDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "educationid")
    private int educationID;
    private int budget;
    private String content;
    private int duration;
    private String exResult;
    private String name;
    private String place;
    private String teacherName;
    private String teacherPhoneNumber;

    @OneToMany(mappedBy = "education", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<EducationStudent> educationStudents = new ArrayList<>();

    // TEST
    public static Education of( EducationDto educationDto ){
        return Education.builder()
                .educationID( educationDto.getEducationID() )
                .budget( educationDto.getBudget() )
                .content( educationDto.getContent() )
                .duration( educationDto.getDuration() )
                .exResult( educationDto.getExResult() )
                .name( educationDto.getName() )
                .place( educationDto.getPlace() )
                .teacherName( educationDto.getTeacherName() )
                .teacherPhoneNumber( educationDto.getTeacherPhoneNumber() )
                .build();
    }
}
