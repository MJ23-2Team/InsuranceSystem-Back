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

    // 기획
    public void campaignPlan(CampaignProgramPlanRequest campaignProgramDto) {
        Insurance campaignInsurance = insuranceRepository.getReferenceById(campaignProgramDto.getInsuranceID());
        campaignProgramDto.setState(CampaignState.RUN);
        campaignProgramRepository.save(CampaignProgram.of(campaignInsurance, campaignProgramDto));
    }

    // state = RUN 조회
    public List<CampaignProgramDto> retrieveRunCampaign() {
        return campaignProgramRepository.findAll()
                .stream()
                .filter(campaignProgram -> campaignProgram.getState() == CampaignState.RUN)
                .map(CampaignProgramDto::of)
                .collect(Collectors.toList());
    }

    // state = END 조회
    public List<CampaignProgramDto> retrieveEndCampaign() {
        return campaignProgramRepository.findAll()
                .stream()
                .filter(campaignProgram -> campaignProgram.getState() == CampaignState.END)
                .map(CampaignProgramDto::of)
                .collect(Collectors.toList());
    }

    // state = END campaign program 실제 손익률 업데이트
    public void setResultCampaign(int campaignId) {
        CampaignProgram endCampaign = campaignProgramRepository.getReferenceById(campaignId);
        endCampaign.setEND_RESULT(endCampaign.END_RESULT);
    }

    // TODO Table 제약 조건 확인
    // 기획된 campaign state -> RUN으로 변경
    public void doCampaignRun(int campaignId) {
        CampaignProgram readyCampaignProgram = campaignProgramRepository.getReferenceById(campaignId);
        CampaignState currentState = readyCampaignProgram.getState();

        if (currentState == CampaignState.END || currentState == CampaignState.PLAN) {
            readyCampaignProgram = OuterActor.runProgram(readyCampaignProgram);
            campaignProgramRepository.save(readyCampaignProgram);
        } else {
            // TODO 에러 메세지(웹 기준 alert 출력)
        }
    }

    // 연습용 단일 조회
    public CampaignProgramDto retrieve(int campaignId) {
        return CampaignProgramDto.of(campaignProgramRepository.getReferenceById(campaignId));
    }
}
