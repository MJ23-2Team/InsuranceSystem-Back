package server.app.insurance.user.employee.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.user.employee.service.CampaignProgramList;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.entity.CampaignProgram;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MarketingPlanningController {

    private final CampaignProgramList campaignProgramList;

    @PostMapping("/campaign")
    public void campaignPlan(@RequestBody CampaignProgramDto campaignProgramDto) {
        campaignProgramList.campaignPlan(campaignProgramDto);
    }

    @GetMapping("/campaign")
    public List<CampaignProgram> runningCampaign() {
       return campaignProgramList.runningCampaign();
    }

}
