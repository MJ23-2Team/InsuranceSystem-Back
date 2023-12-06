package server.app.insurance.intra.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.intra.dto.AssumePolicyCreateRequest;
import server.app.insurance.intra.dto.AssumePolicyRetrieveResponse;
import server.app.insurance.intra.service.UnderWritingList;
import server.app.insurance.user.employee.controller.ContractController;
import server.app.insurance.user.employee.dto.ContractDto;

import java.util.List;

@Tag(name = "UnderWriting 컨트롤러", description = "UnderWriting API입니다.")
@RestController
@RequestMapping("/uw")
@RequiredArgsConstructor
public class UnderWritingController {

    private final UnderWritingList underWritingList;
    private final ContractController contractController;

    @PostMapping()
    public void createUnderWritingPolicy(@RequestBody AssumePolicyCreateRequest assumePolicyDto) {
        underWritingList.createUWPolicy(assumePolicyDto);
    }

    @GetMapping("/basic")
    public List<ContractDto> retrieveBasicContract() {
        return contractController.retrieveBasicContract();
    }

    @PostMapping("/basic")
    public void doBasicUnderWriting(@RequestParam int contractId) {
        contractController.doBasicUnderWriting(contractId);
    }

    @GetMapping("/collaborative")
    public List<ContractDto> retrieveCollaborativeContract() {
        return contractController.retrieveCollaborativeContract();
    }

    @PostMapping("/collaborative")
    public void doCollaborativeUnderWriting(@RequestParam int contractId) {
        contractController.doCollaborativeUnderWriting(contractId);
    }

    @GetMapping("/all")
    public List<AssumePolicyRetrieveResponse> retrieveAll() {
        return underWritingList.retrieveAll();
    }

}
