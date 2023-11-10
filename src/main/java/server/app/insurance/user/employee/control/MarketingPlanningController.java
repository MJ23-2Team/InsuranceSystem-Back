package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.user.employee.service.CampaignProgramList;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.entity.CampaignProgram;

import java.util.List;

@Tag(name = "CampaignProgram 컨트롤러", description = "CampaignProgram API입니다.")
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
