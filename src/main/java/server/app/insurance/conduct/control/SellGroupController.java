package server.app.insurance.conduct.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.conduct.dto.SellGroupDto;
import server.app.insurance.conduct.service.SellGroupList;
import server.app.insurance.user.employee.dto.InsuranceDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SellGroupController {
    private final SellGroupList sellGroupList;
    @PostMapping("/SellGroup/recommand")
    public void evaluateResult(@RequestParam int id,@RequestParam String inf) {sellGroupList.evaluateResult(id,inf);}
    @GetMapping("/SellGroup/recommend")
    public List<InsuranceDto> recommendInsurance() {return sellGroupList.recommendInsurance();}
    @GetMapping("/SellGroup/getAll")
    public List<SellGroupDto> retrieveAll() {return sellGroupList.getAllGroup();}
    @GetMapping("/SellGroup/recommanReason")
    public String recommendInsuranceReason(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupList.recommendInsuranceReason(insuarnceId,customerId);}
    @GetMapping("/SellGroup/fee")
    public int calculateInsuranceFee(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupList.calculateInsuranceFee(insuarnceId,customerId);}
}