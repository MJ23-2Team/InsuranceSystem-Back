package server.app.insurance.user.customer.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.customer.dto.CustomerInformationRequest;
import server.app.insurance.user.customer.service.CustomerList;
import server.app.insurance.user.customer.dto.CustomerDto;

import java.util.List;

@Tag(name = "Customer 컨트롤러", description = "Customer API입니다.")
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerList customerList;

    @PostMapping()
    public void registerInsurance(@RequestParam int customerID, @RequestParam int insuranceID) {
        customerList.registerInsurance(customerID, insuranceID);
    }

    @GetMapping("/{name}")
    public CustomerDto retrieve(@PathVariable String name) {return customerList.retrieve(name);}

    @GetMapping("/retrieveAll")
    public List<CustomerDto> retrieveAll() {
        return customerList.retrieveAll();}

    @GetMapping("/id")
    public CustomerDto retrieveByID(@RequestParam int id) {return customerList.retrieveByID(id);}

    @PutMapping("/information")
        public void updateCustomerInformation(@RequestBody CustomerInformationRequest customerInformationRequest) {
        customerList.updateCustomerInformation(customerInformationRequest);
    }
}
