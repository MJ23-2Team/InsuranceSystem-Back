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

    @PutMapping("/{campaignId}")
    public void runCampaign(@PathVariable int campaignId) {
        campaignProgramList.runCampaign(campaignId);
    }

    @GetMapping("/running")
    public List<CampaignProgramDto> runningCampaign() {
        return campaignProgramList.runningCampaign();
    }

    @GetMapping("/{campaignId}")
    public CampaignProgramDto retrieve(@PathVariable int campaignId) {
        return campaignProgramList.retrieve(campaignId);
    }

    @PutMapping("/end/{campaignId}")
    public void setResultCampaign(@PathVariable int campaignId) {
        campaignProgramList.setResultCampaign(campaignId);
    }

    @GetMapping("/end")
    public List<CampaignProgramDto> endCampaign() {
        return campaignProgramList.endCampaign();
    }
}
