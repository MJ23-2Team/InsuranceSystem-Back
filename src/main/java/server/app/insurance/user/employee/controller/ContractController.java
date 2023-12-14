package server.app.insurance.user.employee.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.dto.ContractWithInsuranceDto;
import server.app.insurance.user.employee.service.ContractList;

import java.util.List;

@Tag(name = "Contract 컨트롤러", description = "Contract API입니다.")
@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ContractList contractList;

    public void doBasicUnderWriting(int contractId) {
        contractList.doBasicUnderWriting(contractId);
    }

    @GetMapping("/basic")
    public List<ContractDto> retrieveBasicContract() {
        return contractList.retrieveBasicContract();
    }

    public void doCollaborativeUnderWriting(int contractId) {
        contractList.doCollaborativeUnderWriting(contractId);
    }

    @GetMapping("/collaborative")
    public List<ContractDto> retrieveCollaborativeContract() {
        return contractList.retrieveCollaborativeContract();
    }

    @GetMapping( "/retrieveContractByCustomerId" )
    public List<ContractWithInsuranceDto> retrieveByCustomerId(int customerId ){
        return contractList.getAllByCustomerId( customerId );
    }
}
