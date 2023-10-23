package server.api.insurance.business;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.CustomerDto;
import server.api.insurance.insurance.InsuranceDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SellGroupControl {
    private final SellGroupService sellGroupService;
    @PostMapping("/SellGroup/recommand")
    public void evaluateResult(@RequestParam int id,@RequestParam String inf) {sellGroupService.evaluateResult(id,inf);}
    @GetMapping("/SellGroup/recommend")
    public List<InsuranceDto> recommendInsurance() {return sellGroupService.recommendInsurance();}
    @GetMapping("/SellGroup/getAll")
    public List<SellGroupDto> retrieveAll() {return sellGroupService.getAllGroup();}
    @GetMapping("/SellGroup/recommanReason")
    public String recommendInsuranceReason(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupService.recommendInsuranceReason(insuarnceId,customerId);}
    @GetMapping("/SellGroup/fee")
    public int calculateInsuranceFee(@RequestParam int insuarnceId,@RequestParam int customerId) {return sellGroupService.calculateInsuranceFee(insuarnceId,customerId);}
    }
