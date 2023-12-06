package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.customer.dto.CustomerDto;
import server.app.insurance.user.customer.repository.CustomerRepository;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.dto.PaymentDto;
import server.app.insurance.user.employee.dto.PaymentWithCustomerDto;
import server.app.insurance.user.employee.entity.Payment;
import server.app.insurance.user.employee.repository.ContractRepository;
import server.app.insurance.user.employee.repository.InsuranceRepository;
import server.app.insurance.user.employee.repository.PaymentRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentList {
    private final PaymentRepository paymentRepository;
    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final InsuranceRepository insuranceRepository;

    public void createPayment( PaymentDto request ){
        paymentRepository.save( Payment.of( request ) );
    }

    public PaymentDto retrievePayment( int id ){
        return PaymentDto.of( paymentRepository.findById( id ).get() );
    }

    public List<PaymentWithCustomerDto> retrieveAllPayment(){
        List<PaymentDto> paymentList = paymentRepository.findAll().stream().map( PaymentDto::of ).collect( Collectors.toList() );
        List<PaymentWithCustomerDto> paymentInfoList = new ArrayList<PaymentWithCustomerDto>();
        for( PaymentDto payment : paymentList ){
            PaymentWithCustomerDto useDTO = new PaymentWithCustomerDto();
            useDTO.setDuration( payment.getDuration() );
            useDTO.setExpireDate( payment.getExpireDate() );
            useDTO.setResult( payment.isResult() );
            useDTO.setAmount( payment.getAmount() );
            int tempContractID = paymentRepository.findByPaymentId(payment.getPaymentID()).getContractID();
            ContractDto currentContract = contractRepository.findByContractId( tempContractID );
            int insuranceID = currentContract.getInsuranceID();
            int customerID = currentContract.getCustomerID();
            InsuranceDto currentInsurance = InsuranceDto.of( insuranceRepository.findById( insuranceID ).get() );
            useDTO.setInsuranceName( currentInsurance.getInsuranceName() );
            CustomerDto currentCustomer = CustomerDto.of( customerRepository.findById( customerID ).get() );
            useDTO.setCustomerName( currentCustomer.getName() );
            paymentInfoList.add( useDTO );
        }
        return paymentInfoList;
    }

    public List<PaymentWithCustomerDto> retrieveAllExpiredPayment() {
        List<PaymentWithCustomerDto> allPaymentInfo = retrieveAllPayment();
        List<PaymentWithCustomerDto> tempPaymentInfoList = new ArrayList<PaymentWithCustomerDto>();
        for( PaymentWithCustomerDto dto : allPaymentInfo ){
            if( dto.isResult() == false ) tempPaymentInfoList.add( dto );
        }
        return tempPaymentInfoList;
    }

    public void checkValidate() {
        LocalDate now = LocalDate.now();
        List<PaymentDto> paymentList = paymentRepository.findAll().stream().map(PaymentDto::of).collect(Collectors.toList());
        Vector<Integer> expiredID = new Vector<Integer>();
        for (PaymentDto payment : paymentList) {
            if (payment.getExpireDate().isBefore(now)) {
                // 만료 날짜가 지난 경우 adviceNote를 생성한다.
            }
        }
    }

    public void updatePayment( PaymentDto request ){
        paymentRepository.save( Payment.of( request ) );
    }

    public void deletePayment( int id ){
        paymentRepository.deleteById( id );
    }
}
