package server.api.insurance.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.exception.CustomException;
import server.api.insurance.insurance.InsuranceDto;
import server.api.insurance.insurance.InsuranceRepository;
import server.api.insurance.insurance.InsuranceState;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SellGroupService {
    private final SellGroupRepository sellGroupRepository;
    private final InsuranceRepository insuranceRepository;
    public List<SellGroupDto> getAllGroup() {
        return sellGroupRepository.findAll().stream()
                .map(SellGroupDto::of)
                .collect(Collectors.toList());
    }
    public List<InsuranceDto> recommendInsurance() {
        return insuranceRepository.findAll()
                .stream()
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.AUTHORIZED)
                .limit(5)
                .map(InsuranceDto::of)
                .collect(Collectors.toList());
    }
    public void evaluateResult(int sellGroupId, String inf){
        if(sellGroupRepository.existsById(sellGroupId)){
            SellGroup sellGroup = sellGroupRepository.findById(sellGroupId).get();
            sellGroup.setExResult(inf);
            sellGroupRepository.save(sellGroup);
        }
        throw new CustomException("판매그룹을 찾을 수 없습니다..");
    }
    public int calculateInsuranceFee(int insuarnceId, int customerId) {
        return new Random().nextInt(10000, 20000);
    }
    public String recommendInsuranceReason(int insuarnceId, int customerId)
    {
        return "~~~ 이유로 이 보험을 추천합니다.";
    }
}