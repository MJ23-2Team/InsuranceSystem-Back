package server.app.insurance.intra.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.app.insurance.intra.dto.EvaluateResultRequest;
import server.app.insurance.intra.dto.SellGroupDto;
import server.app.insurance.intra.entity.SellGroup;
import server.app.insurance.intra.repository.SellGroupRepository;
import server.app.insurance.common.exception.CustomException;
import server.app.insurance.user.customer.dto.CustomerCounselingDto;
import server.app.insurance.user.customer.dto.CustomerCounselingResponse;
import server.app.insurance.user.customer.dto.CustomerDto;
import server.app.insurance.user.customer.entity.CustomerCounseling;
import server.app.insurance.user.customer.repository.CustomerCounselingRepository;
import server.app.insurance.user.customer.state.CounselingState;
import server.app.insurance.user.employee.dto.*;
import server.app.insurance.user.employee.entity.Insurance;
import server.app.insurance.user.employee.entity.UserPersona;
import server.app.insurance.user.employee.repository.CampaignProgramRepository;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.repository.UserPersonaRepository;
import server.app.insurance.user.employee.state.CampaignState;
import server.app.insurance.user.employee.state.InsuranceState;
import server.app.insurance.user.outerActor.OuterActor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SellGroupList {
    private final SellGroupRepository sellGroupRepository;
    private final InsuranceRepository insuranceRepository;
    private final CampaignProgramRepository campaignProgramRepository;
    private final UserPersonaRepository userPersonaRepository;
    private final CustomerCounselingRepository customerCounselingRepository;

    private final OuterActor outerActor;
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
    public void evaluateResult(EvaluateResultRequest request){
        if(sellGroupRepository.existsById(request.getSellGruopID())){
            SellGroup sellGroup = sellGroupRepository.findById(request.getSellGruopID()).get();
            sellGroup.setExResult(request.getInfo());
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

    public CampaignProgramDto choiceCampaignProgram(int insuranceID) {
        Optional<CampaignProgramDto> findCampaignDto = campaignProgramRepository.findAll().stream().map( CampaignProgramDto::of )
                .filter(campaignProgramDto -> campaignProgramDto.getInsuranceID() == insuranceID
                        && campaignProgramDto.getState() == CampaignState.END)
                .findFirst();
        if (findCampaignDto.isEmpty()) {
            return null;
        }
        return findCampaignDto.get();
    }

    public List<UserPersonaDto> retrieveUserPersonas(int insuranceID) {
        return userPersonaRepository.findByInsuranceID(insuranceID);
    }

    public void createUserPersona(UserPersonaDto userPersonaDto) {
        userPersonaRepository.save(UserPersona.of(userPersonaDto));
    }

    public void planSalesPlan(InsuranceSalesRequest insuranceSalesRequest) {
        Insurance insurance = insuranceRepository.findById(insuranceSalesRequest.getInsuranceID()).get();
        insurance.setSalesStartDate(insuranceSalesRequest.getSalesStartDate());
        insurance.setSalesEndDate(insuranceSalesRequest.getSalesEndDate());
        insurance.setGoalPeopleNumber(insuranceSalesRequest.getGoalPeopleNumber());
        insurance.setSalesMethod(insuranceSalesRequest.getSalesMethod());
    }

    private List<CustomerCounselingDto> getCustomerCounselings(CounselingState counselingState) {
        return customerCounselingRepository.findAll().stream().map(CustomerCounselingDto::of)
                .filter(customerCounselingDto -> customerCounselingDto.getCounselingState() == counselingState)
                .collect(Collectors.toList());
    }

    public List<CustomerDto> retrieveAppliedCounselingCustomers() {
        return getCustomerCounselings(CounselingState.APPLIED).stream()
                .map(CustomerCounselingDto::getCustomer)
                .distinct()
                .map(CustomerDto::of)
                .collect(Collectors.toList());
    }

    public List<CustomerCounselingDto> retrieveCustomerCounselingsByCustomerID(int customerID) {
        return customerCounselingRepository.findByInsuranceID(customerID, CounselingState.APPLIED);
    }

    public void updateConsultationSchedule(int customerCounselingID) {
        CustomerCounseling customerCounseling = customerCounselingRepository.findById(customerCounselingID).get();
        customerCounseling.setCounselingState(CounselingState.ACCEPTED_APPLY);
        outerActor.sendSMStoCustomer("상담 일정이 잡혔습니다.");
    }

    public List<CustomerCounselingResponse> retrieveAcceptedApplyCounselingCustomers() {
        return getCustomerCounselings(CounselingState.ACCEPTED_APPLY).stream()
                .map(CustomerCounseling::of)
                .map(CustomerCounselingResponse::of)
                .collect(Collectors.toList());
    }

    public int checkCounselingTime(CustomerCounselingResponse customerCounselingResponse) {
        CustomerCounselingDto customerCounselingDto = CustomerCounselingDto.of(customerCounselingRepository.findById(customerCounselingResponse.getCounselingID()).get());
        LocalDateTime counselingTime = customerCounselingDto.getCounselingTime();
        LocalDateTime startTime = LocalDateTime.now().minusHours(1);
        LocalDateTime endTime = LocalDateTime.now().plusHours(1);
        if (counselingTime.isBefore(startTime) || counselingTime.isAfter(endTime)) {
            return -1;
        }
        return customerCounselingResponse.getCustomerID();
    }

    public List<InsuranceDto> retrieveAuthorizedInsurances() {
        return insuranceRepository.findAll()
                .stream().map( InsuranceDto::of )
                .filter(insurance -> insurance.getInsuranceState() == InsuranceState.AUTHORIZED)
                .collect(Collectors.toList());
    }

}
