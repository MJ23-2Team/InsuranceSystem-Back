package server.app.insurance.intra.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.intra.dto.ContractManagementPolicyDto;
import server.app.insurance.intra.entity.ContractManagementPolicy;
import server.app.insurance.intra.repository.ContractManagementPolicyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractManagementPolicyList {
    private final ContractManagementPolicyRepository contractManagementPolicyRepository;

    public void add( ContractManagementPolicyDto request ){
        contractManagementPolicyRepository.save( ContractManagementPolicy.of( request ) );
    }

    public ContractManagementPolicyDto retrieve( int id ){
        return ContractManagementPolicyDto.of( contractManagementPolicyRepository.findById( id ).get() );
    }

    public List<ContractManagementPolicyDto> retrieveAll(){
        return contractManagementPolicyRepository.findAll().stream().map( ContractManagementPolicyDto::of ).collect( Collectors.toList() );
    }

    public void update( ContractManagementPolicyDto request ){
        contractManagementPolicyRepository.save( ContractManagementPolicy.of( request ) );
    }

    public void delete( int id ){
        contractManagementPolicyRepository.deleteById( id );
    }
}
