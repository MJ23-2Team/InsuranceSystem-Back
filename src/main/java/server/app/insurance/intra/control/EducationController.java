package server.app.insurance.intra.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.EducationDto;
import server.app.insurance.intra.service.EducationList;

import java.util.List;

@Tag(name = "Education 컨트롤러", description = "Education API입니다.")
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
