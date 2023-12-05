package server.app.insurance.intra.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.EducationDto;
import server.app.insurance.intra.service.EducationList;

import java.util.List;

@Tag(name = "Education 컨트롤러", description = "Education API입니다.")
@RestController
@RequestMapping("/education")
@RequiredArgsConstructor
public class EducationController {
    private final EducationList educationList;

    @PostMapping("/add")
    public void createEducation(@RequestBody EducationDto request) {
        educationList.createEducation(request);
    }

    @GetMapping("/getById")
    public EducationDto retrieveEducation(@RequestParam int id) {
        return educationList.retrieveEducation(id);
    }

    @GetMapping("/getAll")
    public List<EducationDto> retrieveAllEducation() {
        return educationList.retrieveAllEducation();
    }

    @PutMapping("/update")
    public void updateEducation(@RequestBody EducationDto request) {
        educationList.updateEducation(request);
    }

    @DeleteMapping("/delete")
    public void deleteEducation(@RequestParam int id) {
        educationList.deleteEducation(id);
    }
}
