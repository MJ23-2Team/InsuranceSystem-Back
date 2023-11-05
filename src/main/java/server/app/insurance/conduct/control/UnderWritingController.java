package server.app.insurance.conduct.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.conduct.dto.AssumePolicyDto;
import server.app.insurance.conduct.entity.AssumePolicy;
import server.app.insurance.conduct.service.UnderWritingList;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UnderWritingController {

    private final UnderWritingList underWritingList;

    @PostMapping("/uwPolicy")
    public AssumePolicy createUWPolicy(@RequestBody AssumePolicyDto assumePolicyDto) {
        return underWritingList.createUWPolicy(assumePolicyDto);
    }

    @GetMapping("/uwPolicy")
    public List<AssumePolicy> retrieveAll() {
        return underWritingList.retrieveAll();
    }

}
