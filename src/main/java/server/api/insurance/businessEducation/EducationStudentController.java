package server.api.insurance.businessEducation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.CustomerDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationStudentController {
    private final EducationStudentService educationStudentService;

    @PostMapping("/educationstudent")
    public void add(@RequestBody EducationStudentDto request) {educationStudentService.add(request);}
    @GetMapping("/educationstudent")
    public EducationStudentDto retrieve(@RequestParam int id) {return educationStudentService.retrieve(id);}
    @GetMapping("/educationstudent/getAll")
    public List<EducationStudentDto> retrieveAll() {return educationStudentService.retrieveAll();}
    @PutMapping("/educationstudent")
    public void update(@RequestBody EducationStudentDto request) {educationStudentService.update(request);}
    @DeleteMapping("/educationstudent")
    public void delete(@RequestParam int id) {educationStudentService.delete(id);}
}
