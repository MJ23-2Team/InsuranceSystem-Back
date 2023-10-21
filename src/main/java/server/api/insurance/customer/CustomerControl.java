package server.api.insurance.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControl {
    private final CustomerService customerService;
    @PostMapping("/customer")
    public void add(@RequestBody CustomerDto request) {customerService.add(request);}
    @GetMapping("/customer")
    public CustomerDto retrieve(@RequestParam int id) {return customerService.retrieve(id);}
    @GetMapping("/customer/getAll")
    public List<CustomerDto> retrieveAll() {return customerService.retrieveAll();}
    @PutMapping("/customer")
    public void update(@RequestBody CustomerDto request) {customerService.update(request);}
    @DeleteMapping("/customer")
    public void delete(@RequestParam int id) {customerService.delete(id);}

    @GetMapping ("/index")
    public List<User> get() {
        List<User> use= new ArrayList<>();
        use.add(User.builder().age(123).name("123").build());
        return use;
    }
    @PostMapping("/index")
    public void add(@RequestBody User user) {
        System.out.println(user.getName());}
}