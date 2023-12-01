package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.employee.dto.RewardDto;
import server.app.insurance.user.employee.entity.Reward;
import server.app.insurance.user.employee.repository.RewardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RewardList {
    private final RewardRepository rewardRepository;

    public void add( RewardDto request ){
        rewardRepository.save( Reward.of( request ) );
    }

    public RewardDto retrieve( int id ){
        return RewardDto.of( rewardRepository.findById( id ).get() );
    }

    public List<RewardDto> retrieveAll(){
        return rewardRepository.findAll().stream().map( RewardDto::of ).collect( Collectors.toList() );
    }

    public List<RewardDto> retrieveByContractId( int contractId ){
        return null;
    }

    public void update( RewardDto request ){
        rewardRepository.save( Reward.of( request ) );
    }

    public void delete( int id ){
        rewardRepository.deleteById( id );
    }
}
