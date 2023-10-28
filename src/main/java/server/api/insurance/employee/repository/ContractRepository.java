package server.api.insurance.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.api.insurance.employee.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
