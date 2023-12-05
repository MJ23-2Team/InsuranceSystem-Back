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
    public void add(@RequestBody EducationDto request) {
        educationList.add(request);
    }

    @GetMapping("/getById")
    public EducationDto retrieve(@RequestParam int id) {
        return educationList.retrieve(id);
    }

    @GetMapping("/getAll")
    public List<EducationDto> retrieveAll() {
        return educationList.retrieveAll();
    }

    @PutMapping("/update")
    public void update(@RequestBody EducationDto request) {
        educationList.update(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        educationList.delete(id);
    }
}
