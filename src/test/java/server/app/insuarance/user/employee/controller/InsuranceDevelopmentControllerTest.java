package server.app.insuarance.user.employee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.app.insurance.InsuranceApplication;
import server.app.insurance.user.employee.dto.InsuranceDesignRequest;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.dto.InsuranceRiskRequest;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.service.InsuranceDevelopmentList;
import server.app.insurance.user.employee.state.InsuranceState;
import server.app.insurance.user.employee.state.InsuranceType;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest(classes = InsuranceApplication.class)
public class InsuranceDevelopmentControllerTest {

    @Autowired
    InsuranceDevelopmentList insuranceDevelopmentList;

    @Autowired
    InsuranceRepository insuranceRepository;


    void setUp() {
        insuranceRepository.deleteAll();
    }

    @Test
    void createInsurancePlan() {
        setUp();
        String reportName = "testInsurance";

        insuranceDevelopmentList.createInsurancePlan(reportName);

        List<InsuranceDto> testInsurances = insuranceDevelopmentList.retrievePlannedInsurances();
        if(testInsurances.stream().anyMatch(insuranceDto -> insuranceDto.getPlanReport().equals(reportName))) {
            System.out.println("TEST_SUCCESS");
        }
    }

    @Test
    void designInsurance() {
        InsuranceDesignRequest testRequest = InsuranceDesignRequest.builder()
                .insuranceID(9)
                .insuranceName("TEST_INSURANCE")
                .insuranceType(InsuranceType.FIRE)
                .salesTarget("STUDENT")
                .canRegistTarget("STUDENT")
                .payment(10000)
                .guarantee("TEST_CONTENT")
                .estimatedDevelopment(10000000)
                .build();
        insuranceDevelopmentList.designInsurance(testRequest);
        Insurance testInsurance = insuranceRepository.findById(9).get();

        boolean testState = testInsurance.getInsuranceState().equals(InsuranceState.DESIGNED);
        boolean testEstimatedProfitRate = testInsurance.getEstimatedProfitRate() == -1f;
        assertTrue(testState);
        assertTrue(testEstimatedProfitRate);

    }

    @Test
    void analyzeInsuranceRate() {
        InsuranceRiskRequest testRequest = InsuranceRiskRequest.builder()
                .insuranceID(9)
                .riskDegree(10)
                .build();
        insuranceDevelopmentList.analyzeInsuranceRate(testRequest);

        Insurance testInsurance = insuranceRepository.findById(9).get();
        boolean testRate =  testInsurance.getRate() == 0.6f;
        assertTrue(testRate);
    }

    @Test
    void authorizeInsurance() {
        Insurance testInsurance = insuranceRepository.findById(9).get();
        InsuranceDto testDto = InsuranceDto.builder()
                        .insuranceID(testInsurance.getInsuranceID())
                                .build();

        InsuranceState testState = insuranceDevelopmentList.authorizeInsurance(testDto);
        assertTrue(testState.equals(InsuranceState.AUTHORIZED));
    }

}
