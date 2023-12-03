package server.app.insurance.user.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.app.insurance.user.customer.dto.CustomerCounselingDto;
import server.app.insurance.user.customer.dto.CustomerCounselingRequest;
import server.app.insurance.user.customer.entity.CustomerCounseling;
import server.app.insurance.user.customer.repository.CustomerCounselingRepository;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.customer.state.CounselingState;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerCounselingList {
    private final CustomerCounselingRepository customerCounselingRepository;
    private final CustomerRepository customerRepository;
    public void counselingApply(CustomerCounselingRequest customerCounselingRequest) {
        CustomerCounseling customerCounseling = new CustomerCounseling();
        customerCounseling.setCustomer(customerRepository.findByCustomerID(customerCounselingRequest.getCustomerID()));
        customerCounseling.setCounselingPlace(customerCounselingRequest.getCounselingPlace());
        customerCounseling.setCounselingState(CounselingState.APPLIED);
        LocalDate localDate = customerCounselingRequest.getCounselingDate();
        LocalTime localTime = customerCounselingRequest.getCounselingTime();
        customerCounseling.setCounselingTime(localDate.atTime(localTime));
        customerCounselingRepository.save(customerCounseling);
    }
}
