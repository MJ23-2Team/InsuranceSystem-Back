package server.api.insurance.user.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.user.dto.UserCreateRequest;
import server.api.insurance.user.dto.UserResponse;
import server.api.insurance.user.dto.UserUpdateRequest;
import server.api.insurance.user.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControl {
    private final UserService userService;
    @PostMapping("/save")
    public void saveUser(@RequestBody UserCreateRequest userCreateRequest) {
        userService.saveUser(userCreateRequest);}
    @GetMapping("/user")
    public List<UserResponse> getUser() {return userService.getUser();}
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {userService.updateUser(request);}
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {userService.deleteUser(name);}
}