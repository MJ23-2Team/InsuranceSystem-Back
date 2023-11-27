package server.app.insurance.user.customer.control;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.user.customer.dto.CustomerInformationRequest;
import server.app.insurance.user.customer.dto.RegisterInsuranceRequest;
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
    public ApiResponse<ContractDto> registerInsurance(@RequestBody RegisterInsuranceRequest registerInsuranceRequest) {
        customerList.registerInsurance(registerInsuranceRequest);
        return ApiResponse.of(CustomerResponseType.REGIST_INSURANCE_SUCCESS);
    }

    @GetMapping("/{name}")
    public CustomerDto retrieve(@PathVariable String name) {return customerList.retrieve(name);}

    @GetMapping("getAll")
    public ApiResponse<List<CustomerDto>> retrieveAll() {
        return ApiResponse.of(CustomerResponseType.RETRIVE_SUCCESS
                ,customerList.retrieveAll());}

    @GetMapping("/id")
    public CustomerDto retrieveByID(@RequestParam int id) {return customerList.retrieveByID(id);}

    @PutMapping("/information")
    public void setCustomerInformation(@RequestBody CustomerInformationRequest customerInformationRequest, @RequestParam int id) {
        customerList.setCustomerInformation(customerInformationRequest, id);
    }
}
