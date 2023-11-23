package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.service.CampaignProgramList;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.entity.CampaignProgram;

import java.util.List;

@Tag(name = "CampaignProgram 컨트롤러", description = "CampaignProgram API입니다.")
@RestController
@RequestMapping("/campaign")
@RequiredArgsConstructor
public class MarketingPlanningController {

    private final CampaignProgramList campaignProgramList;

    @PostMapping()
    public void campaignPlan(@RequestBody CampaignProgramDto campaignProgramDto) {
        campaignProgramList.campaignPlan(campaignProgramDto);
    }

    @PatchMapping()
    public void runCampaign(@RequestParam int campaignId) {
        campaignProgramList.runCampaign(campaignId);
    }

    @GetMapping("/running")
    public List<CampaignProgram> runningCampaign() {
        return campaignProgramList.runningCampaign();
    }

    @GetMapping("/{campaignId}")
    public CampaignProgramDto retrieve(@PathVariable int campaignId) {
        return campaignProgramList.retrieve(campaignId);
    }

    @GetMapping("/end")
    public List<CampaignProgram> endCampaign() {
        return campaignProgramList.endCampaign();
    }
}
