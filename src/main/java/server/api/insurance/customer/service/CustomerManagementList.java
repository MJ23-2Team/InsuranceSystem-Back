package server.api.insurance.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.customer.dto.RegisterRequset;
import server.api.insurance.customer.entity.Customer;
import server.api.insurance.customer.entity.CustomerManagement;
import server.api.insurance.customer.repository.CustomerRepository;
import server.api.insurance.common.exception.CIllegalArgumentException;
import server.api.insurance.customer.repository.CustomerManagementRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerManagementList {
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
        if (!customerManagementRepository.existsByID(request.getId())){
            Customer customer=Customer.of(request.getCustomerDto());
            customerRepository.save(customer);
            customerManagementRepository.save(CustomerManagement.builder()
                    .customer(customer).ID(request.getId()).PW(request.getPw()).build());
        }else{
            throw new CIllegalArgumentException("이미 가입된 계정입니다.");
        }
    }
}
