package server.api.insurance.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.contract.ContractDto;
import server.api.insurance.contract.ContractService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControl {
    private final CustomerService customerService;
    private final ContractService contractService;

    @PostMapping("/customer/registerInsurance")
    public void registerInsurance(@RequestBody ContractDto contractDto) {
        contractService.registerInsurance(contractDto);
    }

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

    @GetMapping ("/index")
    public List<User> get() {
        List<User> use= new ArrayList<>();
        use.add(User.builder().age(123).name("123").build());
        return use;
    }
    @PostMapping("/index")
    public void add(@RequestBody User user) {
        System.out.println(user.getName());}
}
