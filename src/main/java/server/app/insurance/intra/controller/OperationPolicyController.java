package server.app.insurance.intra.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.intra.dto.OperationPolicyManageRequest;
import server.app.insurance.intra.dto.OperationPolicyRecommandResponse;
import server.app.insurance.intra.dto.OperationPolicyRequest;
import server.app.insurance.intra.dto.OperationPolicyResponse;
import server.app.insurance.intra.service.OperationPolicyList;
import server.app.insurance.intra.state.intraResponseType;

import java.util.List;

@Tag(name = "OperationPolicy 컨트롤러", description = "OperationPolicy API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/operationPolicy")
public class OperationPolicyController {
    private final OperationPolicyList operationPolicyList;
    @PostMapping()
    public ApiResponse<Object> establishOperationPolicy(@RequestBody OperationPolicyRequest request) {
        operationPolicyList.establishOperationPolicy(request);
        return ApiResponse.of(intraResponseType.ESTABLISH_SUCCESS);
    }
    @PostMapping("/recommand")
    public ApiResponse<Object> recommandOperationPolicy(@RequestBody OperationPolicyManageRequest request) {
        operationPolicyList.manage(request.getId());
        return ApiResponse.of(intraResponseType.MANAGE_SUCCESS);
    }
    @PostMapping("/pass")
    public ApiResponse<Object> passOperationPolicy(@RequestBody OperationPolicyManageRequest request) {
        operationPolicyList.passOperationPolicy(request.getId());
        return ApiResponse.of(intraResponseType.MAKEOP_SUCCESS);
    }
    @GetMapping("/suggested")
    public ApiResponse<List<OperationPolicyResponse>> retriveSuggestedOperationPolicy() {
        return  ApiResponse.of(intraResponseType.RETRIVE_SUCCESS,
                operationPolicyList.getSuggestedPolicy());}
    @GetMapping("/recommanded")
    public ApiResponse<List<OperationPolicyRecommandResponse>> retriveRecommandedOperationPolicy() {
        return  ApiResponse.of(intraResponseType.RETRIVE_SUCCESS,
                operationPolicyList.geteRecommandedPolicy());}
}
