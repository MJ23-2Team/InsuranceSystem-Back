package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

@Service
@Transactional
@RequiredArgsConstructor
public class ContractList {

    private final ContractRepository contractRepository;
    private final InsuranceRepository insuranceRepository;
    private final CustomerRepository customerRepository;
    private final OuterActor outerActor;

    public void registerInsurance(ContractDto contractDto) {
        Insurance contractInsurance = insuranceRepository.getReferenceById(contractDto.getInsuranceID());
        Customer contractCustomer = customerRepository.getReferenceById(contractDto.getCustomerID());

        contractDto.setContractState(ContractState.ONLINE);
        contractDto.setContractRunState(ContractRunState.READY);
        if(contractCustomer.getIncomeLevel() > 5) {
            contractDto.setContractUWState(ContractUWState.BASIC);
            contractRepository.save(Contract.of(contractDto, contractCustomer, contractInsurance));
        } else if(contractCustomer.getIncomeLevel() <= 5) {
            contractDto.setContractUWState(ContractUWState.COLLABORATIVE);
            contractRepository.save(Contract.of(contractDto, contractCustomer, contractInsurance));
        }

    }

    public void basicUW(ContractDto uwTarget) {
        uwTarget.setContractRunState(ContractRunState.FINISH);
        contractRepository.save(Contract.update(uwTarget));
    }

    public void collaborateUW(ContractDto collaborateUWTarget) {
        Customer contractCustomer = customerRepository.getReferenceById(collaborateUWTarget.getCustomerID());
        boolean result = outerActor.collaborateUW(collaborateUWTarget, contractCustomer.getIncomeLevel());
        if(result) {
            contractRepository.save(Contract.update(collaborateUWTarget));
        } else {
            contractRepository.save(Contract.update(collaborateUWTarget));
        }
    }
}
