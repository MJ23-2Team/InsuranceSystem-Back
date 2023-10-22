package server.api.insurance.underwriting;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.insurance.contract.Contract;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnderWritingService {

    private final AssumePolicyRepository assumePolicyRepository;

    public AssumePolicy createUWPolicy(AssumePolicyDto assumePolicyDto) {
        return assumePolicyRepository.save(AssumePolicy.of(assumePolicyDto));
    }

    public List<AssumePolicy> retrieveAll() {
        return assumePolicyRepository.findAll();
    }

}
