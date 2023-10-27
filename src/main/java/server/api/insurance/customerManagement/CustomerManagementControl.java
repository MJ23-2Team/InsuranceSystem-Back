package server.api.insurance.customerManagement;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.CustomerDto;

@RestController
@RequiredArgsConstructor
public class CustomerManagementControl {
    private final CustomerManagementService customerManagementService;

    @GetMapping("/login")
    public void login(@RequestParam String Id,@RequestParam String pw){
        customerManagementService.login(Id,pw);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequset request) {
        customerManagementService.register(request);
    }

}
