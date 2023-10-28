package server.api.insurance.business.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.insurance.business.dto.AssumePolicyDto;
import server.api.insurance.business.entity.AssumePolicy;
import server.api.insurance.business.repository.AssumePolicyRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UnderWritingList {

    private final AssumePolicyRepository assumePolicyRepository;

    public AssumePolicy createUWPolicy(AssumePolicyDto assumePolicyDto) {
        return assumePolicyRepository.save(AssumePolicy.of(assumePolicyDto));
    }

    public List<AssumePolicy> retrieveAll() {
        return assumePolicyRepository.findAll();
    }

}
