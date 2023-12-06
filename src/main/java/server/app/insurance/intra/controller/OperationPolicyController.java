package server.app.insurance.intra.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.OperationPolicyManageRequest;
import server.app.insurance.intra.dto.OperationPolicyRecommendResponse;
import server.app.insurance.intra.dto.OperationPolicyRequest;
import server.app.insurance.intra.dto.OperationPolicyResponse;
import server.app.insurance.intra.service.OperationPolicyList;

import java.util.List;

@Tag(name = "OperationPolicy 컨트롤러", description = "OperationPolicy API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/operationPolicy")
public class OperationPolicyController {
    private final OperationPolicyList operationPolicyList;
    @PostMapping()
    public void establishOperationPolicy(@RequestBody OperationPolicyRequest request) {
        operationPolicyList.establishOperationPolicy(request);
    }
    @PostMapping("/recommend")
    public void recommendOperationPolicy(@RequestBody OperationPolicyManageRequest request) {
        operationPolicyList.recommendOperationPolicy(request.getId());
    }
    @PostMapping("/pass")
    public void passOperationPolicy(@RequestBody OperationPolicyManageRequest request) {
        operationPolicyList.passOperationPolicy(request.getId());
    }
    @GetMapping("/suggested")
    public List<OperationPolicyResponse> retriveSuggestedOperationPolicy() {
        return  operationPolicyList.getSuggestedPolicy();}
    @GetMapping("/recommended")
    public List<OperationPolicyRecommendResponse> retriveRecommendedOperationPolicy() {
        return  operationPolicyList.geteRecommendedPolicy();}
}
