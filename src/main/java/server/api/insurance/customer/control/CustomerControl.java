package server.api.insurance.customer.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.service.CustomerList;
import server.api.insurance.employee.dto.ContractDto;
import server.api.insurance.employee.service.ContractList;
import server.api.insurance.customer.dto.CustomerDto;
import server.api.insurance.customer.entity.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControl {
    private final CustomerList customerList;
    private final ContractList contractList;

    @PostMapping("/customer/registerInsurance")
    public void registerInsurance(@RequestBody ContractDto contractDto) {
        contractList.registerInsurance(contractDto);
    }

    @PostMapping("/customer")
    public void add(@RequestBody CustomerDto request) {customerList.add(request);}
    @GetMapping("/customer")
    public CustomerDto retrieve(@RequestParam int id) {return customerList.retrieve(id);}
    @GetMapping("/customer/getAll")
    public List<CustomerDto> retrieveAll() {return customerList.retrieveAll();}
    @PutMapping("/customer")
    public void update(@RequestBody CustomerDto request) {customerList.update(request);}
    @DeleteMapping("/customer")
    public void delete(@RequestParam int id) {customerList.delete(id);}

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
