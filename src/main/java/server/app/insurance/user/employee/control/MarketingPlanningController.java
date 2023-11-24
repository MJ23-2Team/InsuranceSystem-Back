package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.user.employee.dto.CampaignProgramPlanRequest;
import server.app.insurance.user.employee.service.CampaignProgramList;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.entity.CampaignProgram;
import server.app.insurance.user.employee.state.EmployeeResponseType;

import java.util.List;

@Tag(name = "CampaignProgram 컨트롤러", description = "CampaignProgram API입니다.")
@RestController
@RequestMapping("/campaign")
@RequiredArgsConstructor
public class MarketingPlanningController {

    private final CampaignProgramList campaignProgramList;

    @PostMapping()
    public ApiResponse<Object> campaignPlan(@RequestBody CampaignProgramPlanRequest campaignProgramDto) {
        campaignProgramList.campaignPlan(campaignProgramDto);
        return ApiResponse.of(EmployeeResponseType.CAMPAIGNPLAN_SUCCESS);
    }

    @PutMapping("/stateRun")
    public ApiResponse<Object> doCampaignRun(@RequestParam int campaignId) {
        campaignProgramList.doCampaignRun(campaignId);
        return ApiResponse.of(EmployeeResponseType.SETCAMPAIGNRUN_SUCCESS);
    }

    @GetMapping("/runCampaign")
    public ApiResponse<List<CampaignProgramDto>> retrieveRunCampaign() {
        return ApiResponse.of(EmployeeResponseType.RETRIEVERUNCAMPAIGN_SUCCESS,
                campaignProgramList.retrieveRunCampaign());
    }

    @GetMapping("/endCampaign")
    public ApiResponse<List<CampaignProgramDto>> retrieveEndCampaign() {
        return ApiResponse.of(EmployeeResponseType.RETRIEVEENDCAMPAIGN_SUCCESS,
                campaignProgramList.retrieveEndCampaign());
    }

    @PutMapping("/result")
    public ApiResponse<Object> setCampaignResult(@RequestParam int campaignId) {
        campaignProgramList.setResultCampaign(campaignId);
        return ApiResponse.of(EmployeeResponseType.SETCAMPAIGNRESULT_SUCCESS);
    }

    @GetMapping()
    public CampaignProgramDto retrieve(@RequestParam int campaignId) {
        return campaignProgramList.retrieve(campaignId);
    }
}
