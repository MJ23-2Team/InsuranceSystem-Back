package server.app.insurance.user.customer.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.user.customer.service.CustomerList;
import server.app.insurance.user.customer.state.CustomerResponseType;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.service.ContractList;
import server.app.insurance.user.customer.dto.CustomerDto;

import java.util.List;

@Tag(name = "Customer 컨트롤러", description = "Customer API입니다.")
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerControl {
    private final CustomerList customerList;

    @PostMapping()
    public void registerInsurance(@RequestParam int customerID, @RequestParam int insuranceID) {
        customerList.registerInsurance(customerID, insuranceID);
    }

    @GetMapping("/{name}")
    public CustomerDto retrieve(@PathVariable String name) {return customerList.retrieve(name);}

    @GetMapping("getAll")
    public ApiResponse<List<CustomerDto>> retrieveAll() {
        return ApiResponse.of(CustomerResponseType.RETRIVE_SUCCESS
                ,customerList.retrieveAll());}
}
