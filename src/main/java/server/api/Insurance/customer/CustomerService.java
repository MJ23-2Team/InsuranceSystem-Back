package server.api.insurance.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository userRepository;

    public void add(CustomerDto request) {userRepository.save(Customer.of(request));}

    public CustomerDto retrieve(int id) {return CustomerDto.of(userRepository.findById(id).get());}

    public List<CustomerDto> retrieveAll() {
        return userRepository.findAll().stream().map(CustomerDto::of).collect(Collectors.toList());
    }

    public void update(CustomerDto request) {userRepository.save(Customer.of(request));}

    public void delete(int id) {userRepository.deleteById(id);}
}