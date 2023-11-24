package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.exception.CInsuranceNotFoundException;
import server.app.insurance.common.util.Constants;
import server.app.insurance.common.util.TimeChecker;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.service.InsuranceDevelopmentList;
import server.app.insurance.user.employee.service.InsuranceList;
import server.app.insurance.user.employee.state.InsuranceState;
import server.app.insurance.user.employee.state.InsuranceType;

import java.util.List;

@Tag(name = "InsuranceDevelopment 컨트롤러", description = "InsuranceDevelopment API입니다.")
@RestController
@RequiredArgsConstructor
public class InsuranceDevelopmentController {
    private final InsuranceDevelopmentList insuranceDevelopmentList;

    @PostMapping("/insurance/plan")
    public void createInsurancePlan(@RequestParam String report) {
        insuranceDevelopmentList.createInsurancePlan(report);
    }

    @PutMapping("/insurance/plan")
    public void manageInsurancePlan(@RequestParam int id, String report) {
        insuranceDevelopmentList.manageInsurancePlan(id, report);
    }

    @DeleteMapping("/insurance/plan")
    public void deleteInsurancePlan(@RequestParam int id) {
        insuranceDevelopmentList.deleteInsurancePlan(id);
    }
    @PutMapping("/insurance/design")
    public InsuranceDto designInsurance(@RequestParam int id, String name, String type, String target, String canResistTarget, String payment, String guarantee, String development) {
        return insuranceDevelopmentList.designInsurance(id, name, type, target, canResistTarget, payment, guarantee, development);
    }
    @PutMapping("/insurance/profit")
    public void estimateProfit(@RequestBody InsuranceDto insuranceDto, Float estimatedProfitRate) {
        insuranceDevelopmentList.estimateProfit(insuranceDto, estimatedProfitRate);
    }
    @PutMapping("/insurance/rate")
    public void analyzeInsuranceRate(@RequestBody InsuranceDto insuranceDto, int riskDegree) throws Exception {
        insuranceDevelopmentList.analyzeInsuranceRate(insuranceDto, riskDegree);
    }
    @PutMapping("/insurance/authorize")
    public void authorizeInsurance(@RequestBody InsuranceDto insuranceDto) {
        insuranceDevelopmentList.authorizeInsurance(insuranceDto);
    }
    @GetMapping("/insurance/planned")
    public List<Insurance> getPlannedInsurances() {
        return insuranceDevelopmentList.getPlannedInsurances();
    }
    @GetMapping("/insurance/designed")
    public List<Insurance> getDesignedInsurances() {
        return insuranceDevelopmentList.getDesignedInsurances();
    }
    @GetMapping("/insurance/authorized")
    public List<Insurance> getAuthorizedInsurances() {
        return insuranceDevelopmentList.getAuthorizedInsurances();
    }
}
