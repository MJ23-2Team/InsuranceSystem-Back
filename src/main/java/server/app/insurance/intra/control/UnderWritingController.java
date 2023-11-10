package server.app.insurance.intra.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.intra.dto.AssumePolicyDto;
import server.app.insurance.intra.entity.AssumePolicy;
import server.app.insurance.intra.service.UnderWritingList;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.service.ContractList;

import java.util.List;

@Tag(name = "UnderWriting 컨트롤러", description = "UnderWriting API입니다.")
@RestController
@RequiredArgsConstructor
public class UnderWritingController {

    private final UnderWritingList underWritingList;
    private final ContractList contractList;

    @PostMapping("/uwPolicy")
    public AssumePolicy createUWPolicy(@RequestBody AssumePolicyDto assumePolicyDto) {
        return underWritingList.createUWPolicy(assumePolicyDto);
    }

    @GetMapping("/uwPolicy")
    public List<AssumePolicy> retrieveAll() {
        return underWritingList.retrieveAll();
    }

    @PutMapping("/underwriting/basic")
    public void basicUW(@RequestBody ContractDto basicUWTarget) {
        contractList.basicUW(basicUWTarget);
    }

    @PutMapping("/underwriting/collaborative")
    public void collaborateUW(@RequestBody ContractDto collaborateUWTarget) {
        contractList.collaborateUW(collaborateUWTarget);
    }
}
