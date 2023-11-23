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
@RequestMapping("/uw")
@RequiredArgsConstructor
public class UnderWritingController {

    private final UnderWritingList underWritingList;
    private final ContractList contractList;

    @PostMapping()
    public AssumePolicy createUWPolicy(@RequestBody AssumePolicyDto assumePolicyDto) {
        return underWritingList.createUWPolicy(assumePolicyDto);
    }

    @GetMapping("/policyAll")
    public List<AssumePolicyDto> retrieveAll() {
        return underWritingList.retrieveAll();
    }

    @PutMapping("/basic/{contractId}")
    public void basicUW(@PathVariable int contractId) {
        contractList.basicUW(contractId);
    }

    @PutMapping("/collaborative/{contractId}")
    public void collaborateUW(@PathVariable int contractId) {
        contractList.collaborateUW(contractId);
    }

    @GetMapping("/all")
    public List<ContractDto> getAll() {
        return contractList.getAll();
    }
}
