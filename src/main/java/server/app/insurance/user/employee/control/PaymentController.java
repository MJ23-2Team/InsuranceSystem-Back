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
    public void add(@RequestBody PaymentDto request) {paymentList.add(request);}
    @GetMapping("/getById")
    public PaymentDto retrieve(@RequestParam int id) {return paymentList.retrieve(id);}
    @GetMapping("/getAll")
    public List<PaymentWithCustomerDto> retrieveAll() {return paymentList.retrieveAll();}
    @GetMapping( "/getAllExpired" )
    public List<PaymentWithCustomerDto> retrieveAllExpired() { return paymentList.retrieveAllExpired(); }
    @GetMapping( "/checkValidate" )
    public void checkValidate() { paymentList.checkValidate(); }
    @PutMapping("/update")
    public void update(@RequestBody PaymentDto request) {paymentList.update(request);}
    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {paymentList.delete(id);}
}
