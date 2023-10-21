package server.api.insurance.businessEducation;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "education") //FK가 없는 쪽에 mappedBy 사용을 추천
    private List<EducationStudent> educationStudents = new ArrayList<>();
}
