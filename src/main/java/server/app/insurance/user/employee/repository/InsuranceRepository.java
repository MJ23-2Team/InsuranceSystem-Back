package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.employee.entity.Insurance;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {

    Insurance findByReport(String planReport);
}
