package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.user.employee.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
