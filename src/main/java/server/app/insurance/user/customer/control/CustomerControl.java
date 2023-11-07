package server.app.insurance.user.customer.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.customer.service.CustomerList;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.service.ContractList;
import server.app.insurance.user.customer.dto.CustomerDto;

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
}
