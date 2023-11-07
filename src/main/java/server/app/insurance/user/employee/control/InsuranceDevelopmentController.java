package server.app.insurance.user.employee.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.common.util.Constants;
import server.app.insurance.user.employee.service.InsuranceDevelopmentList;

@RestController
@RequiredArgsConstructor
public class InsuranceDevelopmentController {
    private final InsuranceDevelopmentList insuranceDevelopmentList;

    @PutMapping("/insurance/establishPolicy")
    public void establishPolicy(Constants.Target target, Constants.Crud crud) {
        insuranceDevelopmentList.establishPolicy(target, crud);
    }
}
