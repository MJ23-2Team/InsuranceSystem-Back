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
@RequestMapping("/insuranceDevelopment")
@RequiredArgsConstructor
public class InsuranceDevelopmentController {
    private final InsuranceDevelopmentList insuranceDevelopmentList;

    @PostMapping("/plan")
    public void createInsurancePlan(@RequestParam String report) {
        insuranceDevelopmentList.createInsurancePlan(report);
    }

    @PutMapping("/plan")
    public void manageInsurancePlan(@RequestParam int id, @RequestParam String report) {
        insuranceDevelopmentList.manageInsurancePlan(id, report);
    }

    @DeleteMapping("/plan")
    public void deleteInsurancePlan(@RequestParam int id) {
        insuranceDevelopmentList.deleteInsurancePlan(id);
    }
    @PutMapping("/design")
    public InsuranceDto designInsurance(@RequestBody InsuranceDto insuranceDto) {
        return insuranceDevelopmentList.designInsurance(insuranceDto);
    }
    @PutMapping("/profit")
    public void estimateProfit(@RequestBody InsuranceDto insuranceDto) {
        insuranceDevelopmentList.estimateProfit(insuranceDto);
    }
    @PutMapping("/rate")
    public void analyzeInsuranceRate(@RequestBody InsuranceDto insuranceDto) {
        insuranceDevelopmentList.analyzeInsuranceRate(insuranceDto);
    }
    @PutMapping("/authorize")
    public void authorizeInsurance(@RequestBody InsuranceDto insuranceDto) {
        insuranceDevelopmentList.authorizeInsurance(insuranceDto);
    }
    @GetMapping("/planned")
    public List<Insurance> getPlannedInsurances() {
        return insuranceDevelopmentList.getPlannedInsurances();
    }
    @GetMapping("/designed")
    public List<Insurance> getDesignedInsurances() {
        return insuranceDevelopmentList.getDesignedInsurances();
    }
    @GetMapping("/authorized")
    public List<Insurance> getAuthorizedInsurances() {
        return insuranceDevelopmentList.getAuthorizedInsurances();
    }
}
