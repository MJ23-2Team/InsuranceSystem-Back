package server.api.insurance.employee.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.api.insurance.employee.dto.CampaignProgramDto;
import server.api.insurance.employee.entity.CampaignProgram;
import server.api.insurance.employee.service.CampaignProgramList;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MarketingPlanningController {

    private final CampaignProgramList campaignProgramList;

    @PostMapping("/campaign")
    public void campaignPlan(@RequestBody CampaignProgramDto campaignProgramDto) {
        campaignProgramList.campaignPlan(campaignProgramDto);
    }

}
