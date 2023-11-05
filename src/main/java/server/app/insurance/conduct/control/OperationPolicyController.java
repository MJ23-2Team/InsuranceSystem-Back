package server.app.insurance.conduct.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.conduct.dto.OperationPolicyDto;
import server.app.insurance.conduct.service.OperationPolicyList;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OperationPolicyController {
    private final OperationPolicyList operationPolicyList;
    @PostMapping("/OperationPolicy")
    public void establishPolicy(@RequestBody OperationPolicyDto request) {operationPolicyList.establishPolicy(request);}
    @PostMapping("/OperationPolicy/recommand")
    public void manage(@RequestParam int id) {operationPolicyList.manage(id);}
    @PostMapping("/OperationPolicy/pass")
    public void makeOPPolicy(@RequestBody int id) {operationPolicyList.makeOPPolicy(id);}
    @GetMapping("/OperationPolicy/getAll")
    public List<OperationPolicyDto> getAllPolicy() {return operationPolicyList.getAllPolicy();}
}
