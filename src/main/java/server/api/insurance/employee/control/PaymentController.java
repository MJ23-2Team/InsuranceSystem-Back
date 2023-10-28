package server.api.insurance.employee.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.employee.service.PaymentList;
import server.api.insurance.employee.dto.PaymentDto;

import java.util.List;

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
