package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.common.exception.CInsuranceNotFoundException;
import server.app.insurance.common.exception.CSaveFailException;
import server.app.insurance.common.exception.DaoException;
import server.app.insurance.common.util.Constants;
import server.app.insurance.common.util.TimeChecker;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.state.InsuranceState;
import server.app.insurance.user.employee.state.InsuranceType;
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
        try {
            insuranceRepository.save(Insurance.of(insuranceDto));
        } catch (DaoException e) {
            throw new CSaveFailException("보고서 저장에 실패했습니다.");
        }
    }

    public void manageInsurancePlan(int id, String report) {
        InsuranceDto insuranceDto = InsuranceDto.of(insuranceRepository.findById(id).get());
        insuranceDto.setPlanReport(report);
    }

    public void deleteInsurancePlan(int id) {
        InsuranceDto insuranceDto = InsuranceDto.of(insuranceRepository.findById(id).get());
        if(insuranceDto.getInsuranceState() != InsuranceState.PLANED) {
            throw new CInsuranceNotFoundException("이미 설계를 시작한 상품입니다.");
        } else {
            insuranceRepository.deleteById(id);
        }
    }

    public InsuranceDto designInsurance(int id, String name, String type, String target, String canResistTarget, String payment, String guarantee, String development) {
        Insurance insurance = insuranceRepository.findById(id).get();
        insurance.setInsuranceName(name);
        insurance.setInsuranceType(InsuranceType.valueOf(type));
        insurance.setSalesTarget(target);
        insurance.setCanRegistTarget(canResistTarget);
        insurance.setPayment(Integer.parseInt(payment));
        insurance.setGuarantee(guarantee);
        insurance.setEstimatedDevelopment(Integer.parseInt(development));
        insurance.setEstimatedProfitRate(-1f);
        insurance.setInsuranceState(InsuranceState.DESIGNED);
        return InsuranceDto.of(insurance);
    }

    public void estimateProfit(InsuranceDto insuranceDto, Float estimatedProfitRate) {
        Insurance insurance = insuranceRepository.findById(insuranceDto.getInsuranceID()).get();
        insurance.setEstimatedProfitRate(estimatedProfitRate);
    }

    public void analyzeInsuranceRate(InsuranceDto insuranceDto, int riskDegree) throws Exception {
        Insurance insurance = insuranceRepository.findById(insuranceDto.getInsuranceID()).get();
        insurance.setRiskDegree(riskDegree);
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

    public List<Insurance> getPlannedInsurances() {
        return insuranceRepository.findAll()
                .stream()
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.PLANED)
                .collect(Collectors.toList());
    }

    public List<Insurance> getDesignedInsurances() {
        return insuranceRepository.findAll()
                .stream()
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.DESIGNED)
                .collect(Collectors.toList());
    }

    public List<Insurance> getAuthorizedInsurances() {
        return insuranceRepository.findAll()
                .stream()
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.AUTHORIZED)
                .collect(Collectors.toList());
    }
}
