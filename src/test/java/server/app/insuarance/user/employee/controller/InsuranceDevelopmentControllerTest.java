package server.app.insuarance.user.employee.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.app.insurance.InsuranceApplication;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.service.InsuranceDevelopmentList;
import server.app.insurance.user.employee.service.InsuranceList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = InsuranceApplication.class)
public class InsuranceDevelopmentControllerTest {

    @Autowired
    InsuranceDevelopmentList insuranceDevelopmentList;

    @Autowired
    InsuranceList insuranceList;

    @Autowired
    InsuranceRepository insuranceRepository;


    @BeforeEach
    void setUp() {
        insuranceRepository.deleteAll();
    }

    @Test
    void createInsurancePlan() {
        String reportName = "testInsurance";
        insuranceDevelopmentList.createInsurancePlan(reportName);

        Insurance testInsurance = insuranceRepository.findByReport(reportName);
        assertThat(testInsurance).isNotNull();
    }

}
