package server.api.insurance.contract;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.CustomerDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/payment")
    public void add(@RequestBody PaymentDto request) {paymentService.add(request);}
    @GetMapping("/payment")
    public PaymentDto retrieve(@RequestParam int id) {return paymentService.retrieve(id);}
    @GetMapping("/payment/getAll")
    public List<PaymentDto> retrieveAll() {return paymentService.retrieveAll();}
    @PutMapping("/payment")
    public void update(@RequestBody PaymentDto request) {paymentService.update(request);}
    @DeleteMapping("/payment")
    public void delete(@RequestParam int id) {paymentService.delete(id);}
}
