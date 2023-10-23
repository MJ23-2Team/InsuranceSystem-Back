package server.api.insurance.business;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.CustomerDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OperationPolicyControl {
    private final OperationPolicyService operationPolicyService;
    @PostMapping("/OperationPolicy")
    public void establishPolicy(@RequestBody OperationPolicyDto request) {operationPolicyService.establishPolicy(request);}
    @PostMapping("/OperationPolicy/recommand")
    public void manage(@RequestParam int id) {operationPolicyService.manage(id);}
    @PostMapping("/OperationPolicy/pass")
    public void makeOPPolicy(@RequestBody int id) {operationPolicyService.makeOPPolicy(id);}
    @GetMapping("/OperationPolicy/getAll")
    public List<OperationPolicyDto> getAllPolicy() {return operationPolicyService.getAllPolicy();}
}
