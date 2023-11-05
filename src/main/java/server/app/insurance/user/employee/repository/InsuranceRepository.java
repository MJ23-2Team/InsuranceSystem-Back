package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.user.employee.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
}
