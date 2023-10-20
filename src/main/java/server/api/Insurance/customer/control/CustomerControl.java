package server.api.insurance.customer.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.dto.CustomerDto;
import server.api.insurance.customer.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControl {
    private final CustomerService customerService;
    @PostMapping("/save")
    public void saveUser(@RequestBody CustomerDto request) {
        customerService.saveUser(request);}
    @GetMapping("/user")
    public List<CustomerDto> getUser() {return customerService.getUser();}
    @PutMapping("/user")
    public void updateUser(@RequestBody CustomerDto request) {
        customerService.updateUser(request);}
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam Long id) {
        customerService.deleteUser(id);}
}