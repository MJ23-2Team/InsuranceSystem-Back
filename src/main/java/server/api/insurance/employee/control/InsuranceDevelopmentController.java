package server.api.insurance.employee.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import server.api.insurance.common.util.Constants;
import server.api.insurance.employee.service.InsuranceDevelopmentList;

@RestController
@RequiredArgsConstructor
public class InsuranceDevelopmentController {
    private final InsuranceDevelopmentList insuranceDevelopmentList;

    @PutMapping("/insurance/establishPolicy")
    public void establishPolicy(Constants.Target target, Constants.Crud crud) {
        insuranceDevelopmentList.establishPolicy(target, crud);
    }
}
