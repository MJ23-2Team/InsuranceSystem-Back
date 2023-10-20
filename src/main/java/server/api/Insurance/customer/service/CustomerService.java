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

    public void saveUser(CustomerDto request) {
        userRepository.save(request);
    }

    public List<CustomerDto> getUser() {return userRepository.findAll();}

    public void updateUser(CustomerDto request) {
        userRepository.save(request);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}