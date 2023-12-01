package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.dto.AdviceNoteDto;
import server.app.insurance.user.employee.service.AdviceNoteList;

import java.util.List;

@Tag(name = "AdviceNote 컨트롤러", description = "AdviceNote API입니다.")
@RestController
@RequestMapping("/advicenote")
@RequiredArgsConstructor
public class AdviceNoteController {
    private final AdviceNoteList adviceNoteList;

    @PostMapping("/add")
    public void add(@RequestBody AdviceNoteDto request) {adviceNoteList.add(request);}
    @GetMapping("/getById")
    public AdviceNoteDto retrieve(@RequestParam int id) {return adviceNoteList.retrieve(id);}
    @GetMapping("/getAll")
    public List<AdviceNoteDto> retrieveAll() {return adviceNoteList.retrieveAll();}
    @GetMapping( "/getByCustomerId")
    public List<AdviceNoteDto> retrieveByCustomerId( @RequestParam int customerId ) {
        return adviceNoteList.retrieveByCustomerId( customerId );
    }
    @PutMapping("/update")
    public void update(@RequestBody AdviceNoteDto request) {adviceNoteList.update(request);}
    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {adviceNoteList.delete(id);}
}
