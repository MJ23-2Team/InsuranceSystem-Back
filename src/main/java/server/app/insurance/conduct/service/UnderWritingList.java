package server.app.insurance.conduct.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.conduct.dto.AssumePolicyDto;
import server.app.insurance.conduct.entity.AssumePolicy;
import server.app.insurance.conduct.repository.AssumePolicyRepository;

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
