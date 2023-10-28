package server.api.insurance.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.insurance.employee.dto.PaymentDto;
import server.api.insurance.employee.entity.Payment;
import server.api.insurance.employee.repository.PaymentRepository;

import java.util.List;
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

    public void update( PaymentDto request ){
        paymentRepository.save( Payment.of( request ) );
    }

    public void delete( int id ){
        paymentRepository.deleteById( id );
    }
}
