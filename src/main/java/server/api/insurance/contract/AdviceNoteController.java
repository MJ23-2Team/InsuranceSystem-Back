package server.api.insurance.contract;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.CustomerDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdviceNoteController {
    private final AdviceNoteService adviceNoteService;

    @PostMapping("/advicenote")
    public void add(@RequestBody AdviceNoteDto request) {adviceNoteService.add(request);}
    @GetMapping("/advicenote")
    public AdviceNoteDto retrieve(@RequestParam int id) {return adviceNoteService.retrieve(id);}
    @GetMapping("/advicenote/getAll")
    public List<AdviceNoteDto> retrieveAll() {return adviceNoteService.retrieveAll();}
    @PutMapping("/advicenote")
    public void update(@RequestBody AdviceNoteDto request) {adviceNoteService.update(request);}
    @DeleteMapping("/advicenote")
    public void delete(@RequestParam int id) {adviceNoteService.delete(id);}
}
