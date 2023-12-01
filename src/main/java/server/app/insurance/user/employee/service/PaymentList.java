package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.employee.dto.PaymentDto;
import server.app.insurance.user.employee.entity.Payment;
import server.app.insurance.user.employee.repository.PaymentRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentList {
    private final PaymentRepository paymentRepository;

    public void add( PaymentDto request ){
        paymentRepository.save( Payment.of( request ) );
    }

    public PaymentDto retrieve( int id ){
        return PaymentDto.of( paymentRepository.findById( id ).get() );
    }

    public List<PaymentDto> retrieveAll(){
        return paymentRepository.findAll().stream().map( PaymentDto::of ).collect( Collectors.toList() );
    }

    public void checkValidate() {
        LocalDate now = LocalDate.now();
        List<PaymentDto> paymentList = paymentRepository.findAll().stream().map( PaymentDto::of ).collect( Collectors.toList() );
        Vector<Integer> expiredID = new Vector<Integer>();
        for( PaymentDto payment : paymentList ){
            if( payment.getExpireDate().isBefore( now ) ){
                // 만료 날짜가 지난 경우 adviceNote를 생성한다.
            }
        }
    }

    public void update( PaymentDto request ){
        paymentRepository.save( Payment.of( request ) );
    }

    public void delete( int id ){
        paymentRepository.deleteById( id );
    }
}
