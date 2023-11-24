package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.user.employee.service.ContractList;

@Tag(name = "Contract 컨트롤러", description = "Contract API입니다.")
@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ContractList contractList;

    public void doBasicUnderWriting(int contractId) {
        contractList.doBasicUnderWriting(contractId);
    }

    public void doCollaborativeUnderWriting(int contractId) {
        contractList.doCollaborativeUnderWriting(contractId);
    }
}
