package server.api.insurance.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.insurance.employee.dto.CampaignProgramDto;
import server.api.insurance.employee.entity.CampaignProgram;
import server.api.insurance.employee.entity.Insurance;
import server.api.insurance.employee.repository.CampaignProgramRepository;
import server.api.insurance.employee.repository.InsuranceRepository;

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
}
