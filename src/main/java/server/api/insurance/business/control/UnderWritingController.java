package server.api.insurance.business.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.business.dto.AssumePolicyDto;
import server.api.insurance.business.entity.AssumePolicy;
import server.api.insurance.business.service.UnderWritingList;
import server.api.insurance.employee.dto.ContractDto;
import server.api.insurance.employee.entity.Contract;
import server.api.insurance.employee.service.ContractList;

import java.util.List;

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
    public void colloborateUW(@RequestBody ContractDto collaboUWTarget) {
        contractList.collaboratUW(collaboUWTarget);
    }
}
