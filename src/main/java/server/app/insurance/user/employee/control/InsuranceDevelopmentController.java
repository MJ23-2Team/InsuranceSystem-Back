package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.dto.*;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.service.InsuranceDevelopmentList;
import server.app.insurance.user.employee.service.InsuranceList;
import server.app.insurance.user.employee.state.InsuranceState;

import java.util.List;

@Tag(name = "InsuranceDevelopment 컨트롤러", description = "InsuranceDevelopment API입니다.")
@RestController
@RequestMapping("/insuranceDevelopment")
@RequiredArgsConstructor
public class InsuranceDevelopmentController {
    private final InsuranceDevelopmentList insuranceDevelopmentList;
    private final InsuranceList insuranceList;

    @PostMapping("/plan")
    public void createInsurancePlan(@RequestParam String report) {
        insuranceDevelopmentList.createInsurancePlan(report);
    }

    @PutMapping("/plan")
    public void manageInsurancePlan(@RequestBody InsurancePlanRequest insurancePlanRequest) {
        insuranceDevelopmentList.manageInsurancePlan(insurancePlanRequest);
    }

    @DeleteMapping("/plan")
    public void deleteInsurancePlan(@RequestParam int id) {
        insuranceDevelopmentList.deleteInsurancePlan(id);
    }
    @PutMapping("/design")
    public InsuranceDto designInsurance(@RequestBody InsuranceDesignRequest insuranceDesignRequest) {
        return insuranceDevelopmentList.designInsurance(insuranceDesignRequest);
    }
    @PutMapping("/profit")
    public void estimateProfit(@RequestBody InsuranceProfitRequest insuranceProfitRequest) {
        insuranceDevelopmentList.estimateProfit(insuranceProfitRequest);
    }
    @PutMapping("/rate")
    public void analyzeInsuranceRate(@RequestBody InsuranceRiskRequest insuranceRiskRequest) {
        insuranceDevelopmentList.analyzeInsuranceRate(insuranceRiskRequest);
    }
    @PutMapping("/authorize")
    public InsuranceState authorizeInsurance(@RequestBody InsuranceDto insuranceDto) {
        return insuranceDevelopmentList.authorizeInsurance(insuranceDto);
    }
    @GetMapping("/reports")
    public List<InsurancePlanRequest> getReports() {
        return insuranceList.retrieveReports();
    }
    @GetMapping("/planned")
    public List<InsuranceDto> getPlannedInsurances() {
        return insuranceDevelopmentList.getPlannedInsurances();
    }
    @GetMapping("/designed")
    public List<InsuranceDto> getDesignedInsurances() {
        return insuranceDevelopmentList.getDesignedInsurances();
    }
    @GetMapping("/authorized")
    public List<InsuranceDto> getAuthorizedInsurances() {
        return insuranceDevelopmentList.getAuthorizedInsurances();
    }
    @GetMapping("/insurance")
    public InsuranceDto getByInsuranceID(@RequestParam int id) {return insuranceDevelopmentList.getByInsuranceID(id);}
}
