package server.app.insurance.intra.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.intra.dto.SellGroupDto;
import server.app.insurance.intra.service.SellGroupList;
import server.app.insurance.user.customer.dto.CustomerCounselingDto;
import server.app.insurance.user.customer.dto.CustomerCounselingResponse;
import server.app.insurance.user.customer.dto.CustomerDto;
import server.app.insurance.user.employee.dto.CampaignProgramDto;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.dto.InsuranceSalesRequest;
import server.app.insurance.user.employee.dto.UserPersonaDto;

import java.util.List;

@Tag(name = "SellGroup 컨트롤러", description = "SellGroup API입니다.")
@RestController
@RequestMapping("/sellGroup")
@RequiredArgsConstructor
public class SellGroupController {
    private final SellGroupList sellGroupList;
    @PostMapping("/recommand")
    public void evaluateResult(@RequestParam int id,@RequestParam String inf) {sellGroupList.evaluateResult(id,inf);}
    @GetMapping("/recommend")
    public List<InsuranceDto> recommendInsurance() {return sellGroupList.recommendInsurance();}
    @GetMapping("/getAll")
    public List<SellGroupDto> retrieveAll() {return sellGroupList.getAllGroup();}
    @GetMapping("/recommanReason")
    public String recommendInsuranceReason(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupList.recommendInsuranceReason(insuarnceId,customerId);}
    @GetMapping("/fee")
    public int calculateInsuranceFee(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupList.calculateInsuranceFee(insuarnceId,customerId);}
    @GetMapping("/campaignProgram")
    public CampaignProgramDto choiceCampaignProgram(@RequestBody InsuranceDto insuranceDto) {return sellGroupList.choiceCampaignProgram(insuranceDto);}
    @GetMapping ("/userPersonas")
    public List<UserPersonaDto> getUserPersonas(@RequestBody InsuranceDto insuranceDto) {return sellGroupList.getUserPersonas(insuranceDto);}
    @PostMapping("/userPersona")
    public void addUserPersona(@RequestBody UserPersonaDto userPersonaDto) {sellGroupList.addUserPersona(userPersonaDto);}
    @PutMapping("/salesPlan")
    public void planSalesPlan(@RequestBody InsuranceSalesRequest insuranceSalesRequest) {sellGroupList.planSalesPlan(insuranceSalesRequest);}
    @GetMapping("/appliedCounselingCustomers")
    public List<CustomerDto> getAppliedCounselingCustomers() {return sellGroupList.getAppliedCounselingCustomers();}
    @GetMapping("/appliedCounselingCustomersByDto")
    public List<CustomerCounselingDto> getCustomerCounselingsByCustomerDto(@RequestBody CustomerDto customerDto) {return sellGroupList.getCustomerCounselingsByCustomerDto(customerDto);}
    @PutMapping("/schedule")
    public void setConsultationSchedule(@RequestBody CustomerCounselingDto customerCounselingDto) {sellGroupList.setConsultationSchedule(customerCounselingDto);}
    @GetMapping("/acceptedApplyCounselingCustomers")
    public List<CustomerCounselingResponse> getAcceptedApplyCounselingCustomers() {return sellGroupList.getAcceptedApplyCounselingCustomers();}
    @GetMapping("/checkTime")
    public int checkCounselingTime(CustomerCounselingResponse customerCounselingResponse) {return sellGroupList.checkCounselingTime(customerCounselingResponse);}
}
