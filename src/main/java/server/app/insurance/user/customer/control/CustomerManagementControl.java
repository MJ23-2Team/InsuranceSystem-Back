package server.app.insurance.user.customer.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.customer.dto.LoginRequset;
import server.app.insurance.user.customer.service.CustomerManagementList;
import server.app.insurance.user.customer.dto.RegisterRequset;

@RestController
@RequiredArgsConstructor
public class CustomerManagementControl {
    private final CustomerManagementList customerManagementList;
    @PostMapping("/login")
    public void login(@RequestBody LoginRequset request){
        System.out.println("123");
        customerManagementList.login(request.getId(),request.getPw());
    }
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequset request) {
        customerManagementList.register(request);
    }
}
