package server.api.insurance.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.api.insurance.employee.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
}
