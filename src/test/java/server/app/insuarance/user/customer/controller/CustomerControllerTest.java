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
import static org.junit.jupiter.api.Assertions.assertTrue;

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

//    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        insuranceRepository.deleteAll();
        contractRepository.deleteAll();
    }

    @Test
    void registerInsuranceTest() {

        int customerID = 1234;
        int insuranceID = 7;

        customerList.registerInsurance(customerID, insuranceID);
        assertThat(contractList.retrieveContract(3)).isNotNull();

        int customerid = 5678;
        customerList.registerInsurance(customerid, insuranceID);
        assertThat(contractList.retrieveContract(4)).isNotNull();
    }

}
