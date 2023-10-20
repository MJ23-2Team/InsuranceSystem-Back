package server.api.insurance.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.customer.CustomerDto;
import server.api.insurance.customer.CustomerRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository userRepository;

    public void add(CustomerDto request) {userRepository.save(request);}

    public CustomerDto retrieve(int id) {return userRepository.findById(id).get();}

    public List<CustomerDto> retrieveAll() {return userRepository.findAll();}

    public void update(CustomerDto request) {userRepository.save(request);}

    public void delete(int id) {userRepository.deleteById(id);}
}