package server.api.insurance.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControl {
    private final CustomerService customerService;
    @PostMapping("/customer")
    public void add(@RequestBody CustomerDto request) {customerService.add(request);}
    @GetMapping("/customer")
    public CustomerDto retrieve(@RequestParam int id) {return customerService.retrieve(id);}
    @GetMapping("/customer/getAll")
    public List<CustomerDto> retrieveAll() {return customerService.retrieveAll();}
    @PutMapping("/customer")
    public void update(@RequestBody CustomerDto request) {customerService.update(request);}
    @DeleteMapping("/customer")
    public void delete(@RequestParam int id) {customerService.delete(id);}
}