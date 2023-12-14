package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.common.util.Constants;
import server.app.insurance.user.customer.dto.CustomerDto;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.dto.RewardDto;
import server.app.insurance.user.employee.entity.Contract;
import server.app.insurance.user.employee.entity.Reward;
import server.app.insurance.user.employee.repository.ContractRepository;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.repository.RewardRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RewardList {
    private final RewardRepository rewardRepository;
    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final InsuranceRepository insuranceRepository;

    public void createReward( RewardDto request ){
        RewardDto saveData = new RewardDto();
        saveData.setAppliDate(LocalDate.now());
        saveData.setContractID( request.getContractID() );
        saveData.setAppliResult( Constants.Result.PROCESS );
        saveData.setRewardAmount( request.getRewardAmount() );
        saveData.setAccidentProfile( request.getAccidentProfile() );
        ContractDto contractDto = ContractDto.of( contractRepository.findById( request.getContractID() ).get() );
        int customerID = contractDto.getCustomerID();
        int insuranceID = contractDto.getInsuranceID();
        CustomerDto customerDto = CustomerDto.of( customerRepository.findById( customerID).get() );
        InsuranceDto insuranceDto = InsuranceDto.of( insuranceRepository.findById( insuranceID ).get() );
        saveData.setRewardAmount( insuranceDto.getRewardAmount() );
        saveData.setCustomerName( customerDto.getName() );
        saveData.setContent( request.getContent() );
        saveData.setIdentifyProfile( request.getIdentifyProfile() );

        Contract contract = contractRepository.findById( request.getContractID() ).get();

        rewardRepository.save( Reward.allOf( saveData, contract ) );
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
