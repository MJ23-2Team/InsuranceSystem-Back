package server.api.insurance.business;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import server.api.insurance.customer.Customer;
import server.api.insurance.insurance.Insurance;
import server.api.insurance.insurance.InsuranceState;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SellGroupControl {
    private final SellGroupService sellGroupService;

    @GetMapping("/sellGroup/getAll")
    public List<SellGroup> getAllGroup() {
        return sellGroupService.getAllGroup();
    }
    @GetMapping("/insurance/getRecommended")
    public List<Insurance> recommendInsurance(Customer customer) {
        return sellGroupService.recommendInsurance(customer);
    }
    @GetMapping("/insurance/getFee")
    public int calculateInsuranceFee(Insurance insurance, Customer customer) {
        return sellGroupService.calculateInsuranceFee(insurance, customer);
    }
    @GetMapping("/insurance/getRecommendedReason")
    public String recommendInsuranceReason(Insurance insurance, Customer customer) {
        return sellGroupService.recommendInsuranceReason(insurance, customer);
    }
}
