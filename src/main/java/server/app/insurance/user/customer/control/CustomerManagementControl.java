package server.app.insurance.user.customer.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.user.customer.dto.LoginRequset;
import server.app.insurance.user.customer.service.CustomerManagementList;
import server.app.insurance.user.customer.dto.RegisterRequset;
import server.app.insurance.user.customer.state.CustomerResponseType;

@Tag(name = "CustomerManagement 컨트롤러", description = "CustomerManagement API입니다.")
@RestController
@RequiredArgsConstructor
public class CustomerManagementControl {
    private final CustomerManagementList customerManagementList;
    @PostMapping("/login")
    public ApiResponse<Object> login(@RequestBody LoginRequset request){
        return ApiResponse.of(CustomerResponseType.LOGIN_SUCCESS,
        customerManagementList.login(request.getId(),request.getPw()));
    }
    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody RegisterRequset request) {
        customerManagementList.register(request);
        return ApiResponse.of(CustomerResponseType.REGIST_SUCCESS);
    }
}
