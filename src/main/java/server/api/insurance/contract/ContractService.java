package server.api.insurance.contract;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.insurance.customer.Customer;
import server.api.insurance.customer.CustomerRepository;
import server.api.insurance.insurance.Insurance;
import server.api.insurance.insurance.InsuranceRepository;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final InsuranceRepository insuranceRepository;
    private final CustomerRepository customerRepository;

    public void registerInsurance(ContractDto contractDto) {
        Insurance contractInsurance = insuranceRepository.getReferenceById(contractDto.getInsuranceID());
        Customer contractCustomer = customerRepository.getReferenceById(contractDto.getCustomerID());
        contractRepository.save(Contract.of(contractDto, contractCustomer, contractInsurance));

    }
}
