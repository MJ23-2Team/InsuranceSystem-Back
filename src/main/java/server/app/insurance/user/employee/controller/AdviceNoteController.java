package server.app.insurance.user.employee.controller;

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
    public void createAdviceNote(@RequestBody AdviceNoteDto request) {adviceNoteList.createAdviceNote(request);}
    @GetMapping("/getById")
    public AdviceNoteDto retrieveAdviceNote(@RequestParam int id) {return adviceNoteList.retrieveAdviceNote(id);}
    @GetMapping("/getAll")
    public List<AdviceNoteDto> retrieveAll() {return adviceNoteList.retrieveAllAdviceNote();}
    @GetMapping( "/getByCustomerId")
    public List<AdviceNoteDto> retrieveAdviceNoteByCustomerId( @RequestParam int customerId ) {
        return adviceNoteList.retrieveAdviceNoteByCustomerId( customerId );
    }
    @PutMapping("/update")
    public void updateAdviceNote(@RequestBody AdviceNoteDto request) {adviceNoteList.updateAdviceNote(request);}
    @DeleteMapping("/delete")
    public void deleteAdviceNote(@RequestParam int id) {adviceNoteList.deleteAdviceNote(id);}
}
