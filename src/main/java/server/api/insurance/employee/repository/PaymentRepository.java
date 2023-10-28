package server.api.insurance.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.api.insurance.employee.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
