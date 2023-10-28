package server.api.insurance.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.business.dto.SellGroupDto;
import server.api.insurance.business.entity.SellGroup;
import server.api.insurance.business.repository.SellGroupRepository;
import server.api.insurance.common.exception.CustomException;
import server.api.insurance.employee.dto.InsuranceDto;
import server.api.insurance.employee.repository.InsuranceRepository;
import server.api.insurance.employee.state.InsuranceState;

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
    public String recommendInsuranceReason(int insuarnceId, int customerId)
    {
        return "~~~ 이유로 이 보험을 추천합니다.";
    }
}