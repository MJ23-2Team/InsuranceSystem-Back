package server.app.insurance.intra.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.EvaluateResultRequest;
import server.app.insurance.intra.dto.SellGroupDto;
import server.app.insurance.intra.service.SellGroupList;
import server.app.insurance.user.customer.dto.CustomerCounselingDto;
import server.app.insurance.user.customer.dto.CustomerCounselingResponse;
import server.app.insurance.user.customer.dto.CustomerDto;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.dto.InsuranceSalesRequest;
import server.app.insurance.user.employee.dto.UserPersonaDto;
import server.app.insurance.user.employee.service.InsuranceDevelopmentList;

import java.util.List;

@Tag(name = "SellGroup 컨트롤러", description = "SellGroup API입니다.")
@RestController
@RequestMapping("/sellGroup")
@RequiredArgsConstructor
public class SellGroupController {
    private final SellGroupList sellGroupList;
    @PostMapping("/evaluateResult")
    public void evaluateResult(@RequestBody EvaluateResultRequest request) {sellGroupList.evaluateResult(request);}
    @GetMapping("/recommend")
    public List<InsuranceDto> recommendInsurance() {return sellGroupList.recommendInsurance();}
    @GetMapping("/retrieveAll")
    public List<SellGroupDto> retrieveAll() {return sellGroupList.getAllGroup();}
    @GetMapping("/recommendReason")
    public String recommendInsuranceReason(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupList.recommendInsuranceReason(insuarnceId,customerId);}
    @GetMapping("/calculateFee")
    public int calculateInsuranceFee(@RequestParam int insuarnceId,@RequestParam int customerId) {
        return sellGroupList.calculateInsuranceFee(insuarnceId,customerId);}
   //
   @GetMapping("/authorized")
   public List<InsuranceDto> retrieveAuthorizedInsurances() {
       return sellGroupList.retrieveAuthorizedInsurances();
   }
    @GetMapping("/campaignProgram")
    public CampaignProgramDto choiceCampaignProgram(@RequestParam int id) {return sellGroupList.choiceCampaignProgram(id);}
    @GetMapping ("/userPersonas")
    public List<UserPersonaDto> retrieveUserPersonas(@RequestParam int id) {
        return sellGroupList.retrieveUserPersonas(id);}
    @PostMapping("/userPersona")
    public void createUserPersona(@RequestBody UserPersonaDto userPersonaDto) {
        sellGroupList.createUserPersona(userPersonaDto);}
    @PutMapping("/salesPlan")
    public void planSalesPlan(@RequestBody InsuranceSalesRequest insuranceSalesRequest) {sellGroupList.planSalesPlan(insuranceSalesRequest);}
    @GetMapping("/appliedCounselingCustomers")
    public List<CustomerDto> retrieveAppliedCounselingCustomers() {return sellGroupList.retrieveAppliedCounselingCustomers();}
    @GetMapping("/appliedCounselings")
    public List<CustomerCounselingDto> retrieveCustomerCounselingsByCustomerID(@RequestParam int customerID) {return sellGroupList.retrieveCustomerCounselingsByCustomerID(customerID);}
    @PutMapping("/schedule")
    public void updateConsultationSchedule(@RequestParam int customerCounselingID) {sellGroupList.updateConsultationSchedule(customerCounselingID);}
    @GetMapping("/acceptedApplyCounselingCustomers")
    public List<CustomerCounselingResponse> retrieveAcceptedApplyCounselingCustomers() {return sellGroupList.retrieveAcceptedApplyCounselingCustomers();}
    @GetMapping("/checkTime")
    public int checkCounselingTime(CustomerCounselingResponse customerCounselingResponse) {return sellGroupList.checkCounselingTime(customerCounselingResponse);}
}
