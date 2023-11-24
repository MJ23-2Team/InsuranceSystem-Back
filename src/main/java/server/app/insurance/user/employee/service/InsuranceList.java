package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.employee.dto.InsuranceDto;
import server.app.insurance.user.employee.repository.InsuranceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InsuranceList {

    private final InsuranceRepository insuranceRepository;

    public List<InsuranceDto> retrieveAll() {
        return insuranceRepository.findAll().stream().map( InsuranceDto::of ).collect( Collectors.toList() );
    }

    public void delete(int id) {
        insuranceRepository.deleteById(id);
    }
}
