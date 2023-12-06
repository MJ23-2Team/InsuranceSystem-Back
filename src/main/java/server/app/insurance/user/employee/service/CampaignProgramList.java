package server.app.insurance.user.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.dto.CampaignProgramPlanRequest;
import server.app.insurance.user.employee.entity.CampaignProgram;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.CampaignProgramRepository;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.state.CampaignState;
import server.app.insurance.user.outerActor.OuterActor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CampaignProgramList {

    private final CampaignProgramRepository campaignProgramRepository;
    private final InsuranceRepository insuranceRepository;

    public void createCampaignPlan(CampaignProgramPlanRequest campaignProgramDto) {
        Insurance campaignInsurance = insuranceRepository.getReferenceById(campaignProgramDto.getInsuranceID());
        campaignProgramDto.setState(CampaignState.PLAN);
        campaignProgramRepository.save(CampaignProgram.of(campaignInsurance, campaignProgramDto));
    }

    public List<CampaignProgramDto> retrievePlanCampaign() {
        return campaignProgramRepository.findAll().stream()
                .filter(campaignProgram -> campaignProgram.getState() == CampaignState.PLAN)
                .map(CampaignProgramDto::of)
                .collect(Collectors.toList());
    }

    public List<CampaignProgramDto> retrieveRunCampaign() {
        return campaignProgramRepository.findAll()
                .stream()
                .filter(campaignProgram -> campaignProgram.getState() == CampaignState.RUN)
                .map(CampaignProgramDto::of)
                .collect(Collectors.toList());
    }

    public List<CampaignProgramDto> retrieveEndCampaign() {
        return campaignProgramRepository.findAll()
                .stream()
                .filter(campaignProgram -> campaignProgram.getState() == CampaignState.END)
                .map(CampaignProgramDto::of)
                .collect(Collectors.toList());
    }

    public void createCampaignResult(int campaignId) {
        CampaignProgram endCampaign = campaignProgramRepository.getReferenceById(campaignId);
        endCampaign.setEND_RESULT(5.5f);
    }

    public void doCampaignRun(int campaignID) {
        CampaignProgram readyCampaignProgram = campaignProgramRepository.getReferenceById(campaignID);
        CampaignState currentState = readyCampaignProgram.getState();
        if (currentState == CampaignState.END || currentState == CampaignState.PLAN) {
            readyCampaignProgram = OuterActor.runProgram(readyCampaignProgram);
            campaignProgramRepository.save(readyCampaignProgram);
        } else {
            // TODO 에러 메세지(웹 기준 alert 출력)
        }
    }

    public void doCampaignEnd(int campaignId) {
        CampaignProgram readyCampaignProgram = campaignProgramRepository.getReferenceById(campaignId);
        CampaignState currentState = readyCampaignProgram.getState();

        if (currentState == CampaignState.RUN) {
            readyCampaignProgram.setState(CampaignState.END);
            campaignProgramRepository.save(readyCampaignProgram);
        } else {
            // TODO 에러 메세지(웹 기준 alert 출력)
        }
    }

}
