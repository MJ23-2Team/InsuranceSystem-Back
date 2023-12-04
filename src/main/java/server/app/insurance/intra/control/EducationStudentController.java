package server.app.insurance.intra.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.EducationStudentDto;
import server.app.insurance.intra.service.EducationStudentList;

import java.util.List;

@Tag(name = "EducationStudent 컨트롤러", description = "EducationStudent API입니다.")
@RestController
@RequestMapping("/educationStudent")
@RequiredArgsConstructor
public class EducationStudentController {
    private final EducationStudentList educationStudentList;

    @PostMapping("/add")
    public void createEducationStudent(@RequestBody EducationStudentDto request) {educationStudentList.createEducationStudent(request);}
    @GetMapping("/getById")
    public EducationStudentDto retrieveEducationStudent(@RequestParam int id) {return educationStudentList.retrieveEducationStudent(id);}
    @GetMapping("/getAll")
    public List<EducationStudentDto> retrieveAllEducationStudent() {return educationStudentList.retrieveAllEducationStudent();}
    @PutMapping("/update")
    public void updateEducationStudent(@RequestBody EducationStudentDto request) {educationStudentList.updateEducationStudent(request);}
    @DeleteMapping("/delete")
    public void deleteEducationStudent(@RequestParam int id) {educationStudentList.deleteEducationStudent(id);}
}
