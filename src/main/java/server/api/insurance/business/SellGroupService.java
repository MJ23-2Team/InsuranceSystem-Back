package server.api.insurance.business;

import org.springframework.stereotype.Service;
import server.api.insurance.customer.Customer;
import server.api.insurance.insurance.Insurance;
import server.api.insurance.insurance.InsuranceRepository;
import server.api.insurance.insurance.InsuranceState;
import server.api.insurance.util.Constants;
import server.api.insurance.util.Team;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SellGroupService extends Team {

    private SellGroupRepository sellGroupRepository;
    private InsuranceRepository insuranceRepository;

    public SellGroupService(SellGroupRepository sellGroupRepository, InsuranceRepository insuranceRepository){
        this.sellGroupRepository = sellGroupRepository;
        this.insuranceRepository = insuranceRepository;
    }
    @Override
    public void establishPolicy(Constants.Target target, Constants.Crud crud) {

    }

    @Override
    public void manage(Constants.Target target, Constants.Crud crud) {

    }

    @Override
    public void plan(Constants.Target target, Constants.Crud crud) {

    }

    @Override
    public void process(Constants.Target target, Constants.Crud crud) {

    }

    public List<SellGroup> getAllGroup() {
        return sellGroupRepository.findAll();
    }
    public List<Insurance> recommendInsurance(Customer customer) {
        return insuranceRepository.findAll()
                .stream()
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.AUTHORIZED)
                .limit(5)
                .collect(Collectors.toList());
    }
    public int calculateInsuranceFee(Insurance insurance, Customer customer) {
        return new Random().nextInt(10000, 20000);
    }
    public String recommendInsuranceReason(Insurance insurance, Customer customer) {
        return "~~~ 이유로 이 보험을 추천합니다.";
    }
}
