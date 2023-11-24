package server.app.insurance.intra.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.app.insurance.intra.dto.SellGroupDto;
import server.app.insurance.intra.entity.SellGroup;
import server.app.insurance.intra.repository.SellGroupRepository;
import server.app.insurance.common.exception.CustomException;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.state.InsuranceState;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SellGroupList {
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
    public String recommendInsuranceReason(int insuarnceId, int customerId){
        return "~~~ 이유로 이 보험을 추천합니다.";
    }
}
