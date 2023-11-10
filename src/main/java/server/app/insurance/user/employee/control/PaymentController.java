package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.service.PaymentList;
import server.app.insurance.user.employee.dto.PaymentDto;

import java.util.List;

@Tag(name = "Payment 컨트롤러", description = "Payment API입니다.")
@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentList paymentList;

    @PostMapping("/payment")
    public void add(@RequestBody PaymentDto request) {paymentList.add(request);}
    @GetMapping("/payment")
    public PaymentDto retrieve(@RequestParam int id) {return paymentList.retrieve(id);}
    @GetMapping("/payment/getAll")
    public List<PaymentDto> retrieveAll() {return paymentList.retrieveAll();}
    @PutMapping("/payment")
    public void update(@RequestBody PaymentDto request) {paymentList.update(request);}
    @DeleteMapping("/payment")
    public void delete(@RequestParam int id) {paymentList.delete(id);}
}
