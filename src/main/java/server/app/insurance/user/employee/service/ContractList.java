package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.entity.Contract;
import server.app.insurance.user.employee.repository.ContractRepository;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.InsuranceRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractList {

    private final ContractRepository contractRepository;
    private final InsuranceRepository insuranceRepository;
    private final CustomerRepository customerRepository;

    public void registerInsurance(ContractDto contractDto) {
        Insurance contractInsurance = insuranceRepository.getReferenceById(contractDto.getInsuranceID());
        Customer contractCustomer = customerRepository.getReferenceById(contractDto.getCustomerID());
        contractRepository.save(Contract.of(contractDto, contractCustomer, contractInsurance));

    }
}
