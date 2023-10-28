package server.api.insurance.employee.dto;

import lombok.*;
import server.api.insurance.common.util.Constants.PayWay;
import server.api.insurance.employee.entity.Payment;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private int paymentID;
    private int contractID;

    private int duration;				// 누적 납부 기간
    private int contractDuration;		// 가입 기간
    private LocalDate expireDate;		// 만기 기간
    private String content;				// 내용
    private int amount;					// 납부해야하는 금액
    private int accidentCount;			// 현재 사고 발생으로 보험금을 타간 횟수
    private PayWay payway;				// 납부 방법
    private boolean result;

    public static PaymentDto of( Payment payment ){
        return PaymentDto.builder()
                .paymentID( payment.getPaymentID() )
                .duration( payment.getDuration() )
                .contractDuration(payment.getContractDuration() )
                .expireDate( payment.getExpireDate() )
                .content( payment.getContent() )
                .amount( payment.getAmount() )
                .accidentCount( payment.getAccidentCount() )
                .payway( payment.getPayway() )
                .result(payment.isResult() )
                .build();
    }
}
