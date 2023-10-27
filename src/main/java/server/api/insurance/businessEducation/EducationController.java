package server.api.insurance.businessEducation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.CustomerDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @PostMapping("/education")
    public void add(@RequestBody EducationDto request) {educationService.add(request);}
    @GetMapping("/education")
    public EducationDto retrieve(@RequestParam int id) {return educationService.retrieve(id);}
    @GetMapping("/education/getAll")
    public List<EducationDto> retrieveAll() {return educationService.retrieveAll();}
    @PutMapping("/education")
    public void update(@RequestBody EducationDto request) {educationService.update(request);}
    @DeleteMapping("/education")
    public void delete(@RequestParam int id) {educationService.delete(id);}
}
