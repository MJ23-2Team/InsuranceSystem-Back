package server.app.insurance.conduct.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.conduct.dto.EducationDto;
import server.app.insurance.conduct.service.EducationList;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationController {
    private final EducationList educationList;

    @PostMapping("/education")
    public void add(@RequestBody EducationDto request) {educationList.add(request);}
    @GetMapping("/education")
    public EducationDto retrieve(@RequestParam int id) {return educationList.retrieve(id);}
    @GetMapping("/education/getAll")
    public List<EducationDto> retrieveAll() {return educationList.retrieveAll();}
    @PutMapping("/education")
    public void update(@RequestBody EducationDto request) {educationList.update(request);}
    @DeleteMapping("/education")
    public void delete(@RequestParam int id) {educationList.delete(id);}
}
