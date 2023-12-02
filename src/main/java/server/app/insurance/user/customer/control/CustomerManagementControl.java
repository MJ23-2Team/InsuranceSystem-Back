package server.app.insurance.user.customer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.user.customer.dto.LoginRequset;
import server.app.insurance.user.customer.dto.RegisterGoogleRequset;
import server.app.insurance.user.customer.service.CustomerAuthList;
import server.app.insurance.user.customer.service.CustomerManagementList;
import server.app.insurance.user.customer.dto.RegisterRequset;
import server.app.insurance.user.customer.state.CustomerResponseType;

@Tag(name = "CustomerManagement 컨트롤러", description = "CustomerManagement API입니다.")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerManagementControl {
    private final CustomerManagementList customerManagementList;
    private final CustomerAuthList customerAuthList;
    @PostMapping("/login")
    public ApiResponse<Integer> login(@RequestBody LoginRequset request){
        return ApiResponse.of(CustomerResponseType.LOGIN_SUCCESS,
        customerManagementList.login(request.getId(),request.getPw()));
    }
    @PostMapping("/register")
    public ApiResponse<Object> register(@RequestBody RegisterRequset request) {
        customerManagementList.register(request);
        return ApiResponse.of(CustomerResponseType.REGIST_SUCCESS);
    }

    @Operation(summary = "구글 연동 로그인 및 계정 등록", description = " https://accounts.google.com/o/oauth2/v2/auth?scope=profile%20email&response_type=code&redirect_uri=http://localhost:8080/login/oauth2/code/google&client_id=535321350238-hah6c37spl3eua2bujvvoug3ql237nns.apps.googleusercontent.com")
    @PostMapping(value = {"/login/oauth2/code/google"})
    public ApiResponse<Object> googleLogin(@RequestBody String token) {
        log.info(token);
        return ApiResponse.of(CustomerResponseType.LOGIN_SUCCESS,
                customerAuthList.login(token));
    }
    @GetMapping(value = {"/login/oauth2/code/google"})
    public ApiResponse<Object> callBack(@RequestParam String code){
        log.info(code);
        return ApiResponse.of(CustomerResponseType.LOGIN_SUCCESS,
                customerAuthList.getAccessToken(code));
    }
    @GetMapping(value = {"/setInfo"})
    public ApiResponse<Boolean> setInfo(@RequestParam int id) {
        return ApiResponse.of(CustomerResponseType.LOGIN_SUCCESS,
                customerManagementList.getInfo(id));
    }

    @PostMapping(value = {"/setInfo"})
    public ApiResponse<Object> setInfo(@RequestBody RegisterGoogleRequset requset) {
        customerManagementList.setInfo(requset);
        return ApiResponse.of(CustomerResponseType.LOGIN_SUCCESS);
    }
}
