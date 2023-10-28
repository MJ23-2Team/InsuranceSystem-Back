package server.api.insurance.customer.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.customer.service.CustomerManagementList;
import server.api.insurance.customer.dto.RegisterRequset;

@RestController
@RequiredArgsConstructor
public class CustomerManagementControl {
    private final CustomerManagementList customerManagementList;

    @GetMapping("/login")
    public void login(@RequestParam String Id,@RequestParam String pw){
        customerManagementList.login(Id,pw);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequset request) {
        customerManagementList.register(request);
    }

}
