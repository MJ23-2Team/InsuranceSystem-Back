package server.app.insurance.intra.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.intra.dto.AssumePolicyCreateRequest;
import server.app.insurance.intra.dto.AssumePolicyDto;
import server.app.insurance.intra.dto.AssumePolicyRetrieveResponse;
import server.app.insurance.intra.entity.AssumePolicy;
import server.app.insurance.intra.repository.AssumePolicyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UnderWritingList {

    private final AssumePolicyRepository assumePolicyRepository;

    public void createUWPolicy(AssumePolicyCreateRequest assumePolicyDto) {
        checkNull(assumePolicyDto);
        checkDuplicateName(assumePolicyDto.getName());
        assumePolicyRepository.save(AssumePolicy.of(assumePolicyDto));
    }

    public List<AssumePolicyRetrieveResponse> retrieveAll() {
        return assumePolicyRepository.findAll()
                .stream()
                .map(AssumePolicyRetrieveResponse::of)
                .collect(Collectors.toList());
    }

    private void checkNull(AssumePolicyCreateRequest assumePolicyCreateRequest) {
        if (assumePolicyCreateRequest.getName() == null
                || assumePolicyCreateRequest.getContent() == null
                || assumePolicyCreateRequest.getPolicyType() == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateName(String title) {
        boolean exist = assumePolicyRepository.findAll()
                            .stream()
                            .anyMatch(assumePolicy -> assumePolicy.getName().equals(title));
        if(!exist) {
            throw new IllegalArgumentException();
        }
    }

}
