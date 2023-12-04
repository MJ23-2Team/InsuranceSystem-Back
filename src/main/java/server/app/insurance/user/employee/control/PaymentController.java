package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.dto.PaymentWithCustomerDto;
import server.app.insurance.user.employee.service.PaymentList;
import server.app.insurance.user.employee.dto.PaymentDto;

import java.util.List;

@Tag(name = "Payment 컨트롤러", description = "Payment API입니다.")
@RestController
@RequestMapping( "/payment" )
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentList paymentList;

    @PostMapping("/add")
    public void createPayment(@RequestBody PaymentDto request) {paymentList.createPayment(request);}
    @GetMapping("/getById")
    public PaymentDto retrievePayment(@RequestParam int id) {return paymentList.retrievePayment(id);}
    @GetMapping("/getAll")
    public List<PaymentWithCustomerDto> retrieveAllPayment() {return paymentList.retrieveAllPayment();}
    @GetMapping( "/getAllExpired" )
    public List<PaymentWithCustomerDto> retrieveAllExpiredPayment() { return paymentList.retrieveAllExpiredPayment(); }
    @GetMapping( "/checkValidate" )
    public void checkValidate() { paymentList.checkValidate(); }
    @PutMapping("/update")
    public void updatePayment(@RequestBody PaymentDto request) {paymentList.updatePayment(request);}
    @DeleteMapping("/delete")
    public void deletePayment(@RequestParam int id) {paymentList.deletePayment(id);}
}
