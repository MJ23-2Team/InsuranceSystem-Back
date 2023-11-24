package server.app.insurance.intra.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.app.insurance.common.util.ApiResponse;
import server.app.insurance.intra.dto.AssumePolicyCreateRequest;
import server.app.insurance.intra.dto.AssumePolicyRetrieveResponse;
import server.app.insurance.intra.service.UnderWritingList;
import server.app.insurance.intra.state.intraResponseType;
import server.app.insurance.user.employee.control.ContractController;

import java.util.List;

@Tag(name = "UnderWriting 컨트롤러", description = "UnderWriting API입니다.")
@RestController
@RequestMapping("/uw")
@RequiredArgsConstructor
public class UnderWritingController {

    private final UnderWritingList underWritingList;
    private final ContractController contractController;

    @PostMapping()
    public ApiResponse<Object> createUnderWritingPolicy(@RequestBody AssumePolicyCreateRequest assumePolicyDto) {
        underWritingList.createUWPolicy(assumePolicyDto);
        return ApiResponse.of(intraResponseType.ESTABLISH_SUCCESS);
    }

    @PutMapping("/basic")
    public ApiResponse<Object> doBasicUnderWriting(@RequestParam int contractId) {
        contractController.doBasicUnderWriting(contractId);
        return ApiResponse.of(intraResponseType.DOBASIC_SUCCESS);
    }

    @PutMapping("/collaborative")
    public ApiResponse<Object> doCollaborativeUnderWriting(@RequestParam int contractId) {
        contractController.doCollaborativeUnderWriting(contractId);
        return ApiResponse.of(intraResponseType.DOCOLLABORATIVE_SUCCESS);
    }

    @GetMapping("/all")
    public ApiResponse<List<AssumePolicyRetrieveResponse>> retrieveAll() {
        return ApiResponse.of(intraResponseType.RETRIVE_SUCCESS, underWritingList.retrieveAll());
    }

}
