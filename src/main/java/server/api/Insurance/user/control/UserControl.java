package server.api.insurance.user.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.api.insurance.user.dto.UserDTO;
import server.api.insurance.user.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControl {
    private final UserService userService;
    @PostMapping("/save")
    public void saveUser(@RequestBody UserDTO request) {
        userService.saveUser(request);}
    @GetMapping("/user")
    public List<UserDTO> getUser() {return userService.getUser();}
    @PutMapping("/user")
    public void updateUser(@RequestBody UserDTO request) {
        userService.updateUser(request);}
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);}
}