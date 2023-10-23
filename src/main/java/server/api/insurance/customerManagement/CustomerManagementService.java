package server.api.insurance.customerManagement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.customer.Customer;
import server.api.insurance.customer.CustomerDto;
import server.api.insurance.customer.CustomerRepository;
import server.api.insurance.exception.CIllegalArgumentException;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerManagementService {
    private final CustomerRepository customerRepository;
    private final CustomerManagementRepository customerManagementRepository;

    public int login(String userId, String password) {
        Optional<CustomerManagement> findCustomer = customerManagementRepository.findAll()
                .stream()
                .filter(customerManagement -> customerManagement.getID().equals(userId) &&
                        customerManagement.getPW().equals(password))
                .findFirst();
        if (findCustomer.isPresent()) {
            return findCustomer.get().getCustomer().getCustomerID();
        }
        throw new CIllegalArgumentException("로그인에 실패했습니다.");
    }
    public void register(RegisterRequset request) {
        if (!customerManagementRepository.findByIDEmpty(request.getId())){
            Customer customer=Customer.of(request.getCustomerDto());
            customerRepository.save(customer);
            customerManagementRepository.save(CustomerManagement.builder()
                    .customer(customer).ID(request.getId()).PW(request.getPw()).build());
        }else{
            throw new CIllegalArgumentException("이미 가입된 계정입니다.");
        }
    }
}
