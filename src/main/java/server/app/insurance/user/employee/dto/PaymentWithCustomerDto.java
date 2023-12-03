package server.app.insurance.user.employee.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentWithCustomerDto {
    private int duration;
    private String customerName;
    private String insuranceName;
    private int amount;
    private LocalDate expireDate;
    private boolean result;
}
