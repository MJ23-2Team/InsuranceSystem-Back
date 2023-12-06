package server.app.insurance.user.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import server.app.insurance.user.employee.dto.PaymentDto;
import server.app.insurance.common.util.Constants;
import server.app.insurance.user.employee.service.ContractList;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentid")
    private int paymentID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractid")
    private Contract contract;

    private int duration;				// 누적 납부 기간
    private int contractDuration;		// 가입 기간
    private LocalDate expireDate;		// 만기 기간
    private String content;				// 내용
    private int amount;					// 납부해야하는 금액
    private int accidentCount;
    @Enumerated(EnumType.STRING)// 현재 사고 발생으로 보험금을 타간 횟수
    private Constants.PayWay payway;				// 납부 방법
    private boolean result;

    public static Payment of( PaymentDto paymentDto ){
        return Payment.builder()
                .paymentID( paymentDto.getPaymentID() )
                .duration( paymentDto.getDuration() )
                .contractDuration(paymentDto.getContractDuration() )
                .expireDate( paymentDto.getExpireDate() )
                .content( paymentDto.getContent() )
                .amount( paymentDto.getAmount() )
                .accidentCount( paymentDto.getAccidentCount() )
                .payway( paymentDto.getPayway() )
                .result(paymentDto.isResult() )
                .build();
    }
}
