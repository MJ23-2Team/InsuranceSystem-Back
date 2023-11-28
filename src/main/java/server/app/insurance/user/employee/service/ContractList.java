package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.customer.dto.CustomerDto;
import server.app.insurance.user.customer.dto.RegisterInsuranceRequest;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.outerActor.OuterActor;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.entity.Contract;
import server.app.insurance.user.employee.repository.ContractRepository;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.state.ContractRunState;
import server.app.insurance.user.employee.state.ContractState;
import server.app.insurance.user.employee.state.ContractUWState;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractList {

    private final ContractRepository contractRepository;
    private final InsuranceRepository insuranceRepository;
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

}
