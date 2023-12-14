package server.app.insuarance.intra.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.app.insurance.InsuranceApplication;
import server.app.insurance.intra.dto.AssumePolicyCreateRequest;
import server.app.insurance.intra.dto.AssumePolicyDto;
import server.app.insurance.intra.dto.AssumePolicyRetrieveResponse;
import server.app.insurance.intra.entity.AssumePolicy;
import server.app.insurance.intra.repository.AssumePolicyRepository;
import server.app.insurance.intra.service.UnderWritingList;
import server.app.insurance.intra.state.PolicyType;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.service.ContractList;
import server.app.insurance.user.employee.state.ContractRunState;
import server.app.insurance.user.employee.state.ContractUWState;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = InsuranceApplication.class)
class UnderWritingControllerTest {

    @Autowired
    UnderWritingList testList;

    @Autowired
    ContractList contractList;

    @Autowired
    AssumePolicyRepository assumePolicyRepository;

    @BeforeEach
    void setUp() {
        assumePolicyRepository.deleteAll();
    }

    @Test
    void createUnderWritingPolicy() {
        AssumePolicyCreateRequest testRequest = new AssumePolicyCreateRequest("test", "testcontent", PolicyType.BASIC);
        testList.createUWPolicy(testRequest);

        AssumePolicy testPolicy = assumePolicyRepository.findByName("test");
        assertThat(testPolicy).isNotNull();
    }

    @Test
    void retrieveBasicContract() {
//        List<ContractDto> testList = contractList.retrieveBasicContract();
//        for(ContractDto test: testList) {
//            assertThat(test.getContractUWState()).isEqualTo(ContractUWState.BASIC);
//        }
    }

    @Test
    void doBasicUnderWriting() {
        contractList.doCollaborativeUnderWriting(4);
        ContractDto contractDto = contractList.retrieveContract(4);
        assertThat(contractDto.getContractRunState().equals(ContractRunState.FINISH));
    }

    @Test
    void retrieveCollaborativeContract() {
//        List<ContractDto> testList = contractList.retrieveCollaborativeContract();
//        for(ContractDto test: testList) {
//            assertTrue(test.getContractUWState().getString().equals("COLLABORATIVE"));
//        }
    }

    @Test
    void doCollaborativeUnderWriting() {
        contractList.doCollaborativeUnderWriting(3);
        ContractDto contractDto = contractList.retrieveContract(3);
        assertThat(contractDto.getContractRunState().equals(ContractRunState.FINISH));
    }

    // DB랑 연동되어 있기 때문에 테스트 시 DB 초기화 먼저
    @Test
    void retrieveAll() {
        AssumePolicyCreateRequest testRequest1 =
                new AssumePolicyCreateRequest("retrieveTest1", "retrieveContent1", PolicyType.BASIC);
        AssumePolicyCreateRequest testRequest2 =
                new AssumePolicyCreateRequest("retrieveTest2", "retrieveContent2", PolicyType.COLLABORATIVE);

        testList.createUWPolicy(testRequest1);
        testList.createUWPolicy(testRequest2);
        List<AssumePolicyRetrieveResponse> testResponse = testList.retrieveAll();
        assertThat(testResponse.size()).isEqualTo(2);
    }
}
