package server.app.insurance.intra.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.OperationPolicyDto;
import server.app.insurance.intra.service.OperationPolicyList;

import java.util.List;

@Tag(name = "OperationPolicy 컨트롤러", description = "OperationPolicy API입니다.")
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
