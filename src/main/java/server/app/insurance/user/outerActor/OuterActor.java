package server.app.insurance.user.outerActor;

import org.springframework.stereotype.Service;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.entity.CampaignProgram;
import server.app.insurance.user.employee.entity.Contract;
import server.app.insurance.user.employee.state.CampaignState;
import server.app.insurance.user.employee.state.ContractRunState;
import server.app.insurance.user.employee.state.InsuranceState;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

@Service
public class OuterActor {

    public static final String OUT_TEAM = "Test_Team";

    public static CampaignProgram runProgram(CampaignProgram readyCampaignProgram) {
        readyCampaignProgram.setState(CampaignState.RUN);
        return readyCampaignProgram;
    }

    public boolean collaborateUW(Contract collaborateUWTarget, int incomeLevel) {
        if(incomeLevel  == 1) {
            collaborateUWTarget.setContractRunState(ContractRunState.DENY);
            return false;
        } else {
            collaborateUWTarget.setContractRunState(ContractRunState.FINISH);
            return true;
        }
    }

    public Callable<LocalDateTime> authorizedInsurance(Insurance insurance) {
        return () -> {
//        throw new RuntimeException("SMS 전송에 실패했습니다. 개발부서에 문의해주세요.");
            insurance.setInsuranceState(InsuranceState.AUTHORIZED);
            return LocalDateTime.now();
        };
    }

    public Callable<Float> calcInsuranceRate(int payment, int riskDegree) {
        return () -> {
//            throw new RuntimeException("SMS 전송에 실패했습니다. 개발부서에 문의해주세요.");
//            Thread.sleep(2days);
            return 0.6f;
        };
    }

}
