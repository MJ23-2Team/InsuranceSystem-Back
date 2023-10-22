package server.api.insurance.insurance;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import server.api.insurance.util.Constants;

@RestController
@RequiredArgsConstructor
public class InsuranceDevelopmentControl {
    private final InsuranceDevelopmentService insuranceDevelopmentService;

    @PutMapping("/insurance/establishPolicy")
    public void establishPolicy(Constants.Target target, Constants.Crud crud) {
        insuranceDevelopmentService.establishPolicy(target, crud);
    }
}
