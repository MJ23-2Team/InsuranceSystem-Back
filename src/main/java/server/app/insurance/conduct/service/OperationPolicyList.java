package server.app.insurance.conduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.app.insurance.conduct.entity.OperationPolicy;
import server.app.insurance.conduct.dto.OperationPolicyDto;
import server.app.insurance.conduct.repository.OperationPolicyRepository;
import server.app.insurance.common.exception.SOPPolicyNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OperationPolicyList {
    private final OperationPolicyRepository operationPolicyRepository;
    public void establishPolicy(OperationPolicyDto dto) {
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
    public List<OperationPolicyDto> getAllPolicy() {
        return operationPolicyRepository.findAll().stream().map(OperationPolicyDto::of).collect(Collectors.toList());
    }
}
