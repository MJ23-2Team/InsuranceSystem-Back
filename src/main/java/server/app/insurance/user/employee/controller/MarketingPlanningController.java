package server.app.insurance.user.employee.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.user.employee.dto.CampaignProgramPlanRequest;
import server.app.insurance.user.employee.service.CampaignProgramList;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.state.EmployeeResponseType;

import java.util.List;

@Tag(name = "CampaignProgram 컨트롤러", description = "CampaignProgram API입니다.")
@RestController
@RequestMapping("/campaign")
@RequiredArgsConstructor
public class MarketingPlanningController {

    private final CampaignProgramList campaignProgramList;

    @PostMapping()
    public void createCampaignPlan(@RequestBody CampaignProgramPlanRequest campaignProgramDto) {
        campaignProgramList.createCampaignPlan(campaignProgramDto);
    }

    @PostMapping("/stateRun")
    public void doCampaignRun(@RequestParam int campaignID) {
        campaignProgramList.doCampaignRun(campaignID);
    }

    @GetMapping("/planCampaign")
    public List<CampaignProgramDto> retrievePlanCampaign() {
        return campaignProgramList.retrievePlanCampaign();
    }

    @GetMapping("/runCampaign")
    public List<CampaignProgramDto> retrieveRunCampaign() {
        return campaignProgramList.retrieveRunCampaign();
    }

    @GetMapping("/endCampaign")
    public List<CampaignProgramDto> retrieveEndCampaign() {
        return campaignProgramList.retrieveEndCampaign();
    }

    @PostMapping("/stateEnd")
    public void doCampaignEnd(@RequestParam int campaignID) {
        campaignProgramList.doCampaignEnd(campaignID);
    }

    @PostMapping("/result")
    public void createCampaignResult(@RequestParam int campaignID) {
        campaignProgramList.createCampaignResult(campaignID);
    }

}
