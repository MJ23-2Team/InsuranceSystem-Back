package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.common.util.Constants;
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

    public void createReward( RewardDto request ){
        rewardRepository.save( Reward.of( request ) );
    }

    public RewardDto retrieveReward( int id ){
        return RewardDto.of( rewardRepository.findById( id ).get() );
    }

    public List<RewardDto> retrieveAllReward(){
        return rewardRepository.findAll().stream().map( RewardDto::of ).collect( Collectors.toList() );
    }

    public List<RewardDto> retrieveRewardByCustomerId( int customerId ){
        List<ContractDto> contractList = contractRepository.findByCustomerId( customerId )
                .stream().map( ContractDto::of ).collect( Collectors.toList() );
        List<Integer> contractIdList = new ArrayList<Integer>();
        for( ContractDto contract: contractList ){
            contractIdList.add( contract.getContractID() );
        }
        return rewardRepository.findAllByContractIds( contractIdList ).stream().map( RewardDto::of ).collect( Collectors.toList() );
    }

    public void updateReward( RewardDto request ){
        rewardRepository.save( Reward.of( request ) );
    }

    public void deleteReward( int id ){
        rewardRepository.deleteById( id );
    }

    public void approveReward( int id, boolean flag ) {
        RewardDto temp = RewardDto.of( rewardRepository.findById( id ).get() );
        if( flag ){
            temp.setAppliResult( Constants.Result.ACCEPT );
        }
        else {
            temp.setAppliResult( Constants.Result.DENY );
        }
        rewardRepository.save( Reward.of( temp ) );
    }
}
