package server.app.insurance.intra.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.intra.dto.AssumePolicyDto;
import server.app.insurance.intra.entity.AssumePolicy;
import server.app.insurance.intra.repository.AssumePolicyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UnderWritingList {

    private final AssumePolicyRepository assumePolicyRepository;

    public AssumePolicy createUWPolicy(AssumePolicyDto assumePolicyDto) {
        return assumePolicyRepository.save(AssumePolicy.of(assumePolicyDto));
    }

    public List<AssumePolicyDto> retrieveAll() {
        return assumePolicyRepository.findAll()
                .stream()
                .map(AssumePolicyDto::of)
                .collect(Collectors.toList());
    }

}
