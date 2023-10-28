package server.api.insurance.business.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.api.insurance.business.dto.AssumePolicyDto;
import server.api.insurance.business.entity.AssumePolicy;
import server.api.insurance.business.service.UnderWritingList;

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
