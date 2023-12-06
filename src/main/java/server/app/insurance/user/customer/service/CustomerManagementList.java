package server.app.insurance.user.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.app.insurance.user.customer.dto.RegisterRequset;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.customer.repository.CustomerManagementRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerManagementList {
    private final CustomerRepository customerRepository;

    public boolean getInfo(int id) {
        Customer customer = customerRepository.findByCustomerID(id);
        if (customer == null || customer.getAddress() == null){
            return true;
        }
        return false;
    }

    public void setInfo(RegisterRequset request) {
        Customer customer = customerRepository.findByCustomerID(request.getId());

        customer.setRole(request.getRole());

        customer.setAddress(request.getCustomerDto().getAddress());
        customer.setAge(request.getCustomerDto().getAge());
        customer.setSex(request.getCustomerDto().getSex());
        customer.setJob(request.getCustomerDto().getJob());
        customer.setName(request.getCustomerDto().getName());
        customer.setPhoneNumber(request.getCustomerDto().getPhoneNumber());
        customer.setRegistrationNumber(request.getCustomerDto().getRegistrationNumber());
        customer.setIncomeLevel(request.getCustomerDto().getIncomeLevel());
        customer.setAccountNumber(request.getCustomerDto().getAccountNumber());
        customer.setAccountPassword(request.getCustomerDto().getAccountPassword());
        customerRepository.save(customer);
    }
}
