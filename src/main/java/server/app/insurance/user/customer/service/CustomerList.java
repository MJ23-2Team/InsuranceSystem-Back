package server.app.insurance.user.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.app.insurance.user.customer.dto.RegisterInsuranceRequest;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.customer.dto.CustomerDto;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.service.ContractList;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerList {
    private final CustomerRepository userRepository;
    private final ContractList contractList;
    public CustomerDto retrieve(String name) {return CustomerDto.of(userRepository.findByName(name));}

    public List<CustomerDto> retrieveAll() {
        return userRepository.findAll().stream().map(CustomerDto::of).collect(Collectors.toList());
    }

    public void registerInsurance(int customerID, int insuranceID) {
        Customer registerCustomer = userRepository.getReferenceById(customerID);
        contractList.registerInsurance(registerCustomer, insuranceID);
    }
}
