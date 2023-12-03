package server.app.insurance.user.customer.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.user.customer.dto.CustomerCounselingDto;
import server.app.insurance.user.customer.dto.CustomerCounselingRequest;
import server.app.insurance.user.customer.service.CustomerCounselingList;

@Tag(name = "CustomerCounseling 컨트롤러", description = "CustomerCounseling API입니다.")
@RestController
@RequestMapping("/customerCounseling")
@RequiredArgsConstructor
public class CustomerCounselingController {
    private final CustomerCounselingList customerCounselingList;
    @PostMapping
    public void counselingApply(@RequestBody CustomerCounselingRequest customerCounselingRequest) {
        customerCounselingList.counselingApply(customerCounselingRequest);
    }

}
