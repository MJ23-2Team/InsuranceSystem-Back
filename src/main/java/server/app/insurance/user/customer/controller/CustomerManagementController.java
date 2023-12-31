package server.app.insurance.user.customer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.customer.dto.LoginResponse;
import server.app.insurance.user.customer.dto.RegisterRequset;
import server.app.insurance.user.customer.service.CustomerAuthList;
import server.app.insurance.user.customer.service.CustomerManagementList;

@Tag(name = "CustomerManagement 컨트롤러", description = "CustomerManagement API입니다.")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerManagementController {
    private final CustomerManagementList customerManagementList;
    private final CustomerAuthList customerAuthList;

    @Operation(summary = "구글 연동 로그인 및 계정 등록", description = " https://accounts.google.com/o/oauth2/v2/auth?scope=profile%20email&response_type=code&redirect_uri=http://localhost:8080/login/oauth2/code/google&client_id=535321350238-hah6c37spl3eua2bujvvoug3ql237nns.apps.googleusercontent.com")
    @PostMapping(value = {"/login/oauth2/code/google"})
    public LoginResponse googleLogin(@RequestBody String token) {
        log.info(token);
        return customerAuthList.login(token);
    }
    @GetMapping(value = {"/login/oauth2/code/google"})
    public String callBack(@RequestParam String code){
        log.info(code);
        return customerAuthList.getAccessToken(code);
    }
    @GetMapping(value = {"/customermanage/Info"})
    public Boolean retirveInfo(@RequestParam int id) {
        return customerManagementList.getInfo(id);
    }

    @PostMapping(value = {"/customermanage/Info"})
    public void createInfo(@RequestBody RegisterRequset requset) {
        customerManagementList.setInfo(requset);
    }

}
