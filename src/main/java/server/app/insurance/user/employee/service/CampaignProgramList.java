package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.entity.CampaignProgram;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.CampaignProgramRepository;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.state.CampaignState;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CampaignProgramList {

    private final CampaignProgramRepository campaignProgramRepository;
    private final InsuranceRepository insuranceRepository;

    public void campaignPlan(CampaignProgramDto campaignProgramDto) {
        Insurance campaignInsurance = insuranceRepository.getReferenceById(campaignProgramDto.getInsuranceID());
        campaignProgramRepository.save(CampaignProgram.of(campaignInsurance, campaignProgramDto));
    }

    public List<CampaignProgram> runningCampaign() {
        return campaignProgramRepository.findAll()
                .stream()
                .filter(campaignProgram -> campaignProgram.getState() == CampaignState.RUN)
                .map(CampaignProgramDto::of)
                .collect(Collectors.toList());
    }
}
