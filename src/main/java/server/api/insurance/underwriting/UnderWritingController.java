package server.api.insurance.underwriting;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UnderWritingController {

    private final UnderWritingService underWritingService;

    @PostMapping("/uwPolicy")
    public AssumePolicy createUWPolicy(@RequestBody AssumePolicyDto assumePolicyDto) {
        return underWritingService.createUWPolicy(assumePolicyDto);
    }

    @GetMapping("/uwPolicy")
    public List<AssumePolicy> retrieveAll() {
        return underWritingService.retrieveAll();
    }

}
