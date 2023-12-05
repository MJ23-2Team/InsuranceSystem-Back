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
    public ApiResponse<Object> createCampaignPlan(@RequestBody CampaignProgramPlanRequest campaignProgramDto) {
        campaignProgramList.createCampaignPlan(campaignProgramDto);
        return ApiResponse.of(EmployeeResponseType.CAMPAIGNPLAN_SUCCESS);
    }

    @PostMapping("/stateRun")
    public ApiResponse<Object> doCampaignRun(@RequestParam int campaignID) {
        campaignProgramList.doCampaignRun(campaignID);
        return ApiResponse.of(EmployeeResponseType.SETCAMPAIGNRUN_SUCCESS);
    }

    @GetMapping("/planCampaign")
    public ApiResponse<List<CampaignProgramDto>> retrievePlanCampaign() {
        return ApiResponse.of(EmployeeResponseType.RETRIEVEALL_SUCCESS, campaignProgramList.retrievePlanCampaign());
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

    @PostMapping("/stateEnd")
    public ApiResponse<Object> doCampaignEnd(@RequestParam int campaignID) {
        campaignProgramList.doCampaignEnd(campaignID);
        return ApiResponse.of(EmployeeResponseType.SETCAMPAIGNEND_SUCCESS);
    }

    @PostMapping("/result")
    public ApiResponse<Object> createCampaignResult(@RequestParam int campaignID) {
        campaignProgramList.createCampaignResult(campaignID);
        return ApiResponse.of(EmployeeResponseType.SETCAMPAIGNRESULT_SUCCESS);
    }

}
