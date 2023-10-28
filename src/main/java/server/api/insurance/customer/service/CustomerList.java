package server.api.insurance.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.customer.repository.CustomerRepository;
import server.api.insurance.customer.dto.CustomerDto;
import server.api.insurance.customer.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerList {
    private final CustomerRepository userRepository;

    public void add(CustomerDto request) {userRepository.save(Customer.of(request));}

    public CustomerDto retrieve(int id) {return CustomerDto.of(userRepository.findById(id).get());}

    public List<CustomerDto> retrieveAll() {
        return userRepository.findAll().stream().map(CustomerDto::of).collect(Collectors.toList());
    }

    public void update(CustomerDto request) {userRepository.save(Customer.of(request));}

    public void delete(int id) {userRepository.deleteById(id);}
}