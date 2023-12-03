package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.dto.RewardDto;
import server.app.insurance.user.employee.entity.Reward;
import server.app.insurance.user.employee.repository.ContractRepository;
import server.app.insurance.user.employee.repository.RewardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RewardList {
    private final RewardRepository rewardRepository;
    private final ContractRepository contractRepository;

    public void add( RewardDto request ){
        rewardRepository.save( Reward.of( request ) );
    }

    public RewardDto retrieve( int id ){
        return RewardDto.of( rewardRepository.findById( id ).get() );
    }

    public List<RewardDto> retrieveAll(){
        return rewardRepository.findAll().stream().map( RewardDto::of ).collect( Collectors.toList() );
    }

    public List<RewardDto> retrieveByCustomerId( int customerId ){
        List<ContractDto> contractList = contractRepository.findByCustomerId( customerId )
                .stream().map( ContractDto::of ).collect( Collectors.toList() );
        List<Integer> contractIdList = new ArrayList<Integer>();
        for( ContractDto contract: contractList ){
            contractIdList.add( contract.getContractID() );
        }
        return rewardRepository.findAllByContractIds( contractIdList ).stream().map( RewardDto::of ).collect( Collectors.toList() );
    }

    public void update( RewardDto request ){
        rewardRepository.save( Reward.of( request ) );
    }

    public void delete( int id ){
        rewardRepository.deleteById( id );
    }
}
