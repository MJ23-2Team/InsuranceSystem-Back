package server.api.insurance.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.insurance.customer.entity.Customer;
import server.api.insurance.customer.repository.CustomerRepository;
import server.api.insurance.employee.dto.ContractDto;
import server.api.insurance.employee.entity.Contract;
import server.api.insurance.employee.repository.ContractRepository;
import server.api.insurance.employee.entity.Insurance;
import server.api.insurance.employee.repository.InsuranceRepository;

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
