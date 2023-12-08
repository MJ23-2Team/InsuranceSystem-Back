package server.app.insuarance.user.customer.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.app.insurance.InsuranceApplication;
import server.app.insurance.common.util.Constants;
import server.app.insurance.user.customer.entity.Customer;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.customer.service.CustomerList;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.ContractRepository;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.service.ContractList;
import server.app.insurance.user.employee.state.InsuranceState;
import server.app.insurance.user.employee.state.InsuranceType;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = InsuranceApplication.class)
public class CustomerControllerTest {

    @Autowired
    CustomerList customerList;

    @Autowired
    ContractList contractList;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    InsuranceRepository insuranceRepository;

    @Autowired
    ContractRepository contractRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        insuranceRepository.deleteAll();
        contractRepository.deleteAll();
    }

    @Test
    void registerInsuranceTest() {
//        Customer testCustomer = new Customer(1, "test", "test", 24, Constants.Gender.MALE, "student", "woo",
//                "000-0000-0000", "12345", 4, "111111", "1234");
        Customer testCustomer = Customer.builder().name("test").sex(Constants.Gender.MALE).incomeLevel(4).build();
        Insurance testInsurance = Insurance.builder()
                .insuranceName("insuranceTest")
                .insuranceState(InsuranceState.AUTHORIZED)
                .insuranceType(InsuranceType.FIRE)
                .payment(1111)
                .rate(1)
                .build();

        customerRepository.save(testCustomer);
        insuranceRepository.save(testInsurance);

        customerList.registerInsurance(testCustomer.getCustomerID(), testInsurance.getInsuranceID());
        assertThat(contractList.retrieveContract(1)).isNotNull();
    }
}
