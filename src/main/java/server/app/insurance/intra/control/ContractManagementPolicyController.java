package server.app.insurance.intra.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.ContractManagementPolicyDto;
import server.app.insurance.intra.service.ContractManagementPolicyList;

import java.util.List;

@Tag(name = "ContractManagementPolicy 컨트롤러", description = "ContractManagementPolicy API입니다.")
@RestController
@RequestMapping( "/contractManagement")
@RequiredArgsConstructor
public class ContractManagementPolicyController {
    private final ContractManagementPolicyList contractManagementPolicyList;

    @PostMapping( "/add")
    public void createContractManagementPolicy(@RequestBody ContractManagementPolicyDto request ){
        contractManagementPolicyList.createContractManagementPolicy( request );
    }

    @GetMapping( "/getById")
    public ContractManagementPolicyDto retrieveContractManagementPolicy( @RequestParam int id ){
        return contractManagementPolicyList.retrieveContractManagementPolicy( id );
    }

    @GetMapping( "/getAll" )
    public List<ContractManagementPolicyDto> retrieveAllContractManagementPolicy(){
        return contractManagementPolicyList.retrieveAllContractManagementPolicy();
    }

    @PutMapping( "/update" )
    public void updateContractManagementPolicy( @RequestBody ContractManagementPolicyDto request ){
        contractManagementPolicyList.updateContractManagementPolicy( request );
    }

    @DeleteMapping( "/delete" )
    public void deleteContractManagementPolicy( @RequestParam int id ){
        contractManagementPolicyList.deleteContractManagementPolicy( id );
    }
}
