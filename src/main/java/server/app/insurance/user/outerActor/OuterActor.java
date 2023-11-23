package server.app.insurance.user.outerActor;

import org.springframework.stereotype.Service;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.entity.CampaignProgram;
import server.app.insurance.user.employee.state.CampaignState;
import server.app.insurance.user.employee.state.ContractRunState;

@Service
public class OuterActor {

    public static final String OUT_TEAM = "Test_Team";

    public static CampaignProgram runProgram(CampaignProgram readyCampaignProgram) {
        readyCampaignProgram.setState(CampaignState.RUN);
        return readyCampaignProgram;
    }

    public boolean collaborateUW(ContractDto collaborateUWTarget, int incomeLevel) {
        if(incomeLevel  == 1) {
            collaborateUWTarget.setContractRunState(ContractRunState.DENY);
            return false;
        } else {
            collaborateUWTarget.setContractRunState(ContractRunState.FINISH);
            return true;
        }
    }

}
