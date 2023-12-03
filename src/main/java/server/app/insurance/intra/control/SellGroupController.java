package server.app.insurance.intra.control;

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
import server.app.insurance.user.employee.entity.UserPersona;

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
    @GetMapping("/getAll")
    public List<SellGroupDto> retrieveAll() {return sellGroupList.getAllGroup();}
    @GetMapping("/recommendReason")
    public String recommendInsuranceReason(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupList.recommendInsuranceReason(insuarnceId,customerId);}
    @GetMapping("/fee")
    public int calculateInsuranceFee(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupList.calculateInsuranceFee(insuarnceId,customerId);}
   //

    @GetMapping("/campaignProgram")
    public CampaignProgramDto choiceCampaignProgram(@RequestParam int id) {return sellGroupList.choiceCampaignProgram(id);}
    @GetMapping ("/userPersonas")
    public List<UserPersonaDto> getUserPersonas(@RequestParam int id) {
        return sellGroupList.getUserPersonas(id);}
    @PostMapping("/userPersona")
    public void addUserPersona(@RequestBody UserPersonaDto userPersonaDto) {
        sellGroupList.addUserPersona(userPersonaDto);}
    @PutMapping("/salesPlan")
    public void planSalesPlan(@RequestBody InsuranceSalesRequest insuranceSalesRequest) {sellGroupList.planSalesPlan(insuranceSalesRequest);}
    @GetMapping("/appliedCounselingCustomers")
    public List<CustomerDto> getAppliedCounselingCustomers() {return sellGroupList.getAppliedCounselingCustomers();}
    @GetMapping("/appliedCounselings")
    public List<CustomerCounselingDto> getCustomerCounselingsByCustomerID(@RequestParam int customerID) {return sellGroupList.getCustomerCounselingsByCustomerID(customerID);}
    @PutMapping("/schedule")
    public void setConsultationSchedule(@RequestParam int customerCounselingID) {sellGroupList.setConsultationSchedule(customerCounselingID);}
    @GetMapping("/acceptedApplyCounselingCustomers")
    public List<CustomerCounselingResponse> getAcceptedApplyCounselingCustomers() {return sellGroupList.getAcceptedApplyCounselingCustomers();}
    @GetMapping("/checkTime")
    public int checkCounselingTime(CustomerCounselingResponse customerCounselingResponse) {return sellGroupList.checkCounselingTime(customerCounselingResponse);}
}
