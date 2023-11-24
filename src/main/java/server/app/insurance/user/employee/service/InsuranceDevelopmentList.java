package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.common.exception.CInsuranceNotFoundException;
import server.app.insurance.common.exception.CSaveFailException;
import server.app.insurance.common.exception.DaoException;
import server.app.insurance.common.util.TimeChecker;
import server.app.insurance.user.employee.dto.*;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.state.InsuranceState;
import server.app.insurance.user.outerActor.OuterActor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InsuranceDevelopmentList {
    private final InsuranceRepository insuranceRepository;
    private final OuterActor outerActor;

    public void createInsurancePlan(String report) {
        InsuranceDto insuranceDto = new InsuranceDto();
        insuranceDto.setPlanReport(report);
        insuranceDto.setInsuranceState(InsuranceState.PLANED);
        try {
            insuranceRepository.save(Insurance.of(insuranceDto));
        } catch (DaoException e) {
            throw new CSaveFailException("보고서 저장에 실패했습니다.");
        }
    }

    public void manageInsurancePlan(InsurancePlanRequest insurancePlanRequest) {
        Insurance insurance = insuranceRepository.findById(insurancePlanRequest.getInsuranceID()).get();
        insurance.setPlanReport(insurancePlanRequest.getPlanReport());
    }

    public void deleteInsurancePlan(int id) {
        InsuranceDto insuranceDto = InsuranceDto.of(insuranceRepository.findById(id).get());
        if(insuranceDto.getInsuranceState() != InsuranceState.PLANED) {
            throw new CInsuranceNotFoundException("이미 설계를 시작한 상품입니다.");
        } else {
            insuranceRepository.deleteById(id);
        }
    }

    public InsuranceDto designInsurance(InsuranceDesignRequest insuranceDesignRequest) {
        Insurance insurance = insuranceRepository.findById(insuranceDesignRequest.getInsuranceID()).get();
        insurance.setInsuranceName(insuranceDesignRequest.getInsuranceName());
        insurance.setInsuranceType(insuranceDesignRequest.getInsuranceType());
        insurance.setSalesTarget(insuranceDesignRequest.getSalesTarget());
        insurance.setCanRegistTarget(insuranceDesignRequest.getCanRegistTarget());
        insurance.setPayment(insuranceDesignRequest.getPayment());
        insurance.setGuarantee(insuranceDesignRequest.getGuarantee());
        insurance.setEstimatedDevelopment(insuranceDesignRequest.getEstimatedDevelopment());
        insurance.setEstimatedProfitRate(-1f);
        insurance.setInsuranceState(InsuranceState.DESIGNED);
        return InsuranceDto.of(insurance);
    }

    public InsuranceDto estimateProfit(InsuranceProfitRequest insuranceProfitRequest) {
        Insurance insurance = insuranceRepository.findById(insuranceProfitRequest.getInsuranceID()).get();
        insurance.setEstimatedProfitRate(insuranceProfitRequest.getEstimatedProfitRate());
        return InsuranceDto.of(insurance);
    }

    public void analyzeInsuranceRate(InsuranceRiskRequest insuranceRiskRequest) {
        Insurance insurance = insuranceRepository.findById(insuranceRiskRequest.getInsuranceID()).get();
        insurance.setRiskDegree(insuranceRiskRequest.getRiskDegree());
        Float rate = TimeChecker.actorNotResponseCheck(
                outerActor.calcInsuranceRate(insurance.getPayment(), insurance.getRiskDegree()),
                2, "요율검증부서의 응답이 없습니다.");
        insurance.setRate(rate);
    }

    public void authorizeInsurance(InsuranceDto insuranceDto) {
        Insurance insurance = insuranceRepository.findById(insuranceDto.getInsuranceID()).get();
        LocalDateTime authorizedDate;
        authorizedDate = TimeChecker.actorNotResponseCheck(
                outerActor.authorizedInsurance(insurance), 2, "인가를 실패했습니다.");
        if (insurance.getInsuranceState() == InsuranceState.AUTHORIZED) {
            insurance.setDuration(8);
            insurance.setResultAnalysis(10);
            insurance.setRewardAmount(20);
            insurance.setSalesPerformance(30);
            System.out.println(
                    authorizedDate.getMonth().getValue() + "월 " + authorizedDate.getDayOfMonth() + "일에 합격 되었습니다");
        } else {
            System.out.println("불합격되었습니다.");
        }
    }

    public List<InsuranceDto> getPlannedInsurances() {
        return insuranceRepository.findAll()
                .stream().map( InsuranceDto::of )
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.PLANED)
                .collect(Collectors.toList());
    }

    public List<InsuranceDto> getDesignedInsurances() {
        return insuranceRepository.findAll()
                .stream().map( InsuranceDto::of )
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.DESIGNED)
                .collect(Collectors.toList());
    }

    public List<InsuranceDto> getAuthorizedInsurances() {
        return insuranceRepository.findAll()
                .stream().map( InsuranceDto::of )
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.AUTHORIZED)
                .collect(Collectors.toList());
    }
}
