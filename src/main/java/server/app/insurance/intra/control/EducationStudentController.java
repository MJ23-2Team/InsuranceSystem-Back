package server.app.insurance.intra.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.EducationStudentDto;
import server.app.insurance.intra.service.EducationStudentList;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationStudentController {
    private final EducationStudentList educationStudentList;

    @PostMapping("/educationstudent")
    public void add(@RequestBody EducationStudentDto request) {educationStudentList.add(request);}
    @GetMapping("/educationstudent")
    public EducationStudentDto retrieve(@RequestParam int id) {return educationStudentList.retrieve(id);}
    @GetMapping("/educationstudent/getAll")
    public List<EducationStudentDto> retrieveAll() {return educationStudentList.retrieveAll();}
    @PutMapping("/educationstudent")
    public void update(@RequestBody EducationStudentDto request) {educationStudentList.update(request);}
    @DeleteMapping("/educationstudent")
    public void delete(@RequestParam int id) {educationStudentList.delete(id);}
}
