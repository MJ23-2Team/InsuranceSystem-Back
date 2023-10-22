package server.api.insurance.contractManagement;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.contract.Contract;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContractManagementPolicyController {
    private final ContractManagementPolicyService contractManagementPolicyService;

    @PostMapping( "/contractmanagementpolicy")
    public void add(@RequestBody ContractManagementPolicyDto request ){
        contractManagementPolicyService.add( request );
    }

    @GetMapping( "/contractmanagementpolicy")
    public ContractManagementPolicyDto retrieve( @RequestParam int id ){
        return contractManagementPolicyService.retrieve( id );
    }

    @GetMapping( "/contractmanagementpolicy/getAll" )
    public List<ContractManagementPolicyDto> retrieveAll(){
        return contractManagementPolicyService.retrieveAll();
    }

    @PutMapping( "/contractmanagementpolicy" )
    public void update( @RequestBody ContractManagementPolicyDto request ){
        contractManagementPolicyService.update( request );
    }

    @DeleteMapping( "/contractmanagementpolicy" )
    public void delete( @RequestParam int id ){
        contractManagementPolicyService.delete( id );
    }
}
