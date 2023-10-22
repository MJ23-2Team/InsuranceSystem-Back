package server.api.insurance.contractManagement;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContractManagementPolicyController {
    private final ContractManagementPolicyService contractManagementPolicyService;
}
