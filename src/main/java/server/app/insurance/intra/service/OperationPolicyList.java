package server.app.insurance.intra.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.app.insurance.intra.dto.OperationPolicyResponse;
import server.app.insurance.intra.entity.OperationPolicy;
import server.app.insurance.intra.dto.OperationPolicyRequest;
import server.app.insurance.intra.repository.OperationPolicyRepository;
import server.app.insurance.common.exception.SOPPolicyNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OperationPolicyList {
    private final OperationPolicyRepository operationPolicyRepository;
    public void establishPolicy(OperationPolicyRequest dto) {
        operationPolicyRepository.save(OperationPolicy.of(dto));
    }

    public void manage(int id) {
        OperationPolicy operationPolicy = operationPolicyRepository.findById(id).get();
        if(operationPolicy.getPass()==0){
            operationPolicy.setRating(operationPolicy.getRating()+1);
            operationPolicyRepository.save(operationPolicy);
        }else {
            throw new SOPPolicyNotFoundException("건의된 운영 방침이 없습니다.");
        }
    }
    public void makeOPPolicy(int id) {
        OperationPolicy operationPolicy = operationPolicyRepository.findById(id).get();
        operationPolicy.setPass(1);
        operationPolicyRepository.save(operationPolicy);
    }
    public List<OperationPolicyResponse> getAllPolicy() {
        return operationPolicyRepository.findAll().stream().map(OperationPolicyResponse::of).collect(Collectors.toList());
    }
}
