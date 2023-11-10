package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.dto.AdviceNoteDto;
import server.app.insurance.user.employee.service.AdviceNoteList;

import java.util.List;

@Tag(name = "AdviceNote 컨트롤러", description = "AdviceNote API입니다.")
@RestController
@RequiredArgsConstructor
public class AdviceNoteController {
    private final AdviceNoteList adviceNoteList;

    @PostMapping("/advicenote")
    public void add(@RequestBody AdviceNoteDto request) {adviceNoteList.add(request);}
    @GetMapping("/advicenote")
    public AdviceNoteDto retrieve(@RequestParam int id) {return adviceNoteList.retrieve(id);}
    @GetMapping("/advicenote/getAll")
    public List<AdviceNoteDto> retrieveAll() {return adviceNoteList.retrieveAll();}
    @PutMapping("/advicenote")
    public void update(@RequestBody AdviceNoteDto request) {adviceNoteList.update(request);}
    @DeleteMapping("/advicenote")
    public void delete(@RequestParam int id) {adviceNoteList.delete(id);}
}
