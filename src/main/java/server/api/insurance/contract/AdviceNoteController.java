package server.api.insurance.contract;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdviceNoteController {
    private final AdviceNoteService adviceNoteService;
}
