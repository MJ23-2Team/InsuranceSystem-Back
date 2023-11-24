package server.app.insurance.intra.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.intra.dto.OperationPolicyManageRequest;
import server.app.insurance.intra.dto.OperationPolicyRequest;
import server.app.insurance.intra.dto.OperationPolicyResponse;
import server.app.insurance.intra.service.OperationPolicyList;
import server.app.insurance.intra.state.intraResponseType;

import java.util.List;

@Tag(name = "OperationPolicy 컨트롤러", description = "OperationPolicy API입니다.")
@RestController
@RequiredArgsConstructor
public class OperationPolicyController {
    private final OperationPolicyList operationPolicyList;
    @PostMapping("/OperationPolicy")
    public ApiResponse<Object> establishPolicy(@RequestBody OperationPolicyRequest request) {
        operationPolicyList.establishPolicy(request);
        return ApiResponse.of(intraResponseType.ESTABLISH_SUCCESS);}
    @PostMapping("/OperationPolicy/recommand")
    public ApiResponse<Object> manage(@RequestBody OperationPolicyManageRequest request) {
        operationPolicyList.manage(request.getId());
        return ApiResponse.of(intraResponseType.MANAGE_SUCCESS);
    }
    @PostMapping("/OperationPolicy/pass")
    public ApiResponse<Object> makeOPPolicy(@RequestBody OperationPolicyManageRequest request) {
        operationPolicyList.makeOPPolicy(request.getId());
        return ApiResponse.of(intraResponseType.MAKEOP_SUCCESS);
    }
    @GetMapping("/OperationPolicy/getAll")
    public ApiResponse<List<OperationPolicyResponse>> getAllPolicy() {
        return  ApiResponse.of(intraResponseType.RETRIVE_SUCCESS,
                operationPolicyList.getAllPolicy());}
}
