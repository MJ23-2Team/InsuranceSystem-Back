package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.customer.dto.CustomerDto;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.employee.dto.ContractWithInsuranceDto;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.outerActor.OuterActor;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.entity.Contract;
import server.app.insurance.user.employee.repository.ContractRepository;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.state.ContractRunState;
import server.app.insurance.user.employee.state.ContractState;
import server.app.insurance.user.employee.state.ContractUWState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractList {

    private final ContractRepository contractRepository;
    private final InsuranceRepository insuranceRepository;
    private final CustomerRepository customerRepository;
    private final OuterActor outerActor;

    public void registerInsurance(Customer registerCustomer, int insuranceID) {
        Insurance contractInsurance = insuranceRepository.getReferenceById(insuranceID);
        ContractDto newContract = ContractDto.builder().build();

        newContract.setContractState(ContractState.ONLINE);
        newContract.setContractRunState(ContractRunState.READY);

        if(registerCustomer.getIncomeLevel() > 5) {
            newContract.setContractUWState(ContractUWState.BASIC);
            contractRepository.save(Contract.of(newContract, registerCustomer, contractInsurance));
        } else if(registerCustomer.getIncomeLevel() <= 5) {
            newContract.setContractUWState(ContractUWState.COLLABORATIVE);
            contractRepository.save(Contract.of(newContract, registerCustomer, contractInsurance));
        }
    }

    public ContractDto registerOffLine(Customer registCustomer, int insuranceId, String contractFile) {
        Insurance contractInsurance = insuranceRepository.getReferenceById(insuranceId);
        ContractDto newContract = ContractDto.builder().build();

        newContract.setContractState(ContractState.OFFLINE);
        newContract.setContractRunState(ContractRunState.READY);
        newContract.setContractFile(contractFile);

        if(registCustomer.getIncomeLevel() > 5) {
            newContract.setContractUWState(ContractUWState.BASIC);
        } else if(registCustomer.getIncomeLevel() <= 5) {
            newContract.setContractUWState(ContractUWState.COLLABORATIVE);
        }
        contractRepository.save(Contract.of(newContract, registCustomer, contractInsurance));
        return ContractDto.of(Contract.of(newContract, registCustomer, contractInsurance));
    }
    public void doBasicUnderWriting(int contractId) {
        Contract target = contractRepository.getReferenceById(contractId);
        target.setContractRunState(ContractRunState.FINISH);
        contractRepository.save(target);
    }

    public List<ContractDto> retrieveBasicContract() {
        return contractRepository.findAll().stream().filter(contract -> contract.getContractUWState() == ContractUWState.BASIC)
                .map(ContractDto::of).collect(Collectors.toList());
    }

    public List<ContractDto> retrieveCollaborativeContract() {
        return contractRepository.findAll().stream().filter(contract -> contract.getContractUWState() == ContractUWState.COLLABORATIVE)
                .map(ContractDto::of).collect(Collectors.toList());
    }

    public void doCollaborativeUnderWriting(int contractId) {
        Contract collaborateTarget = contractRepository.getReferenceById(contractId);
        Customer contractCustomer = collaborateTarget.getCustomer();
        boolean result = outerActor.collaborateUW(collaborateTarget, contractCustomer.getIncomeLevel());
        if(result) {
            collaborateTarget.setContractRunState(ContractRunState.FINISH);
        } else {
            collaborateTarget.setContractRunState(ContractRunState.DENY);
        }
    }

    public List<ContractDto> getAll() {
        List<ContractDto> contractList = contractRepository.findAll()
                .stream()
                .map(ContractDto::of)
                .collect(Collectors.toList());
        return contractList;
    }

    public ContractDto retrieveContract( int contractId ){
        return ContractDto.of( contractRepository.findById( contractId ).get() );
    }

    public List<ContractWithInsuranceDto> getAllByCustomerId( int customerId ){
        List<ContractDto> contractDtos = contractRepository.findByCustomerId( customerId ).stream().map( ContractDto::of ).collect( Collectors.toList() );
        List<ContractWithInsuranceDto> forRewardDto = new ArrayList<ContractWithInsuranceDto>();
        for( ContractDto contractDto : contractDtos ){
            int insuranceID = contractDto.getInsuranceID();
            InsuranceDto insuranceDto = InsuranceDto.of( insuranceRepository.findById( insuranceID ).get() );
            ContractWithInsuranceDto tmp = new ContractWithInsuranceDto();
            tmp.setContractID( contractDto.getContractID() );
            tmp.setInsuranceID( insuranceDto.getInsuranceID() );
            tmp.setInsuranceName( insuranceDto.getInsuranceName() );
            tmp.setRewardAmount( insuranceDto.getRewardAmount() );
            CustomerDto customerDto = CustomerDto.of( customerRepository.findById( contractDto.getCustomerID() ).get() );
            forRewardDto.add( tmp );
        }
        return forRewardDto;
    }

}
