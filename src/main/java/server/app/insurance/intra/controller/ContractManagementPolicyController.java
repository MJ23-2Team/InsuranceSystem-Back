package server.app.insurance.intra.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.ContractManagementPolicyDto;
import server.app.insurance.intra.service.ContractManagementPolicyList;

import java.util.List;

@Tag(name = "ContractManagementPolicy 컨트롤러", description = "ContractManagementPolicy API입니다.")
@RestController
<<<<<<< HEAD
=======
@RequestMapping( "/contractManagement")
>>>>>>> 92d8f69c5dcec6a63900125aacd631e7a0e7b0e9
@RequiredArgsConstructor
public class ContractManagementPolicyController {
    private final ContractManagementPolicyList contractManagementPolicyList;

<<<<<<< HEAD
    @PostMapping( "/contractmanagementpolicy")
    public void add(@RequestBody ContractManagementPolicyDto request ){
        contractManagementPolicyList.add( request );
    }

    @GetMapping( "/contractmanagementpolicy")
    public ContractManagementPolicyDto retrieve( @RequestParam int id ){
        return contractManagementPolicyList.retrieve( id );
    }

    @GetMapping( "/contractmanagementpolicy/getAll" )
    public List<ContractManagementPolicyDto> retrieveAll(){
        return contractManagementPolicyList.retrieveAll();
    }

    @PutMapping( "/contractmanagementpolicy" )
    public void update( @RequestBody ContractManagementPolicyDto request ){
        contractManagementPolicyList.update( request );
    }

    @DeleteMapping( "/contractmanagementpolicy" )
    public void delete( @RequestParam int id ){
        contractManagementPolicyList.delete( id );
=======
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
>>>>>>> 92d8f69c5dcec6a63900125aacd631e7a0e7b0e9
    }
}
