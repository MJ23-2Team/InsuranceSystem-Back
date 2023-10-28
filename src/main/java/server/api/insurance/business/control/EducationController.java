package server.api.insurance.business.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.business.dto.EducationDto;
import server.api.insurance.business.service.EducationList;

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
