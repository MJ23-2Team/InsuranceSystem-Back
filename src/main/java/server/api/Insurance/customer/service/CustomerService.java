package server.api.insurance.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.customer.dto.CustomerDto;
import server.api.insurance.customer.dto.CustomerDto;
import server.api.insurance.customer.repository.CustomerRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository userRepository;

    public void add(CustomerDto request) {userRepository.save(request);}

    public CustomerDto retrieve(Long id) {return userRepository.findById(id).get();}

    public List<CustomerDto> retrieveAll() {return userRepository.findAll();}

    public void update(CustomerDto request) {userRepository.save(request);}

    public void delete(Long id) {userRepository.deleteById(id);}
}