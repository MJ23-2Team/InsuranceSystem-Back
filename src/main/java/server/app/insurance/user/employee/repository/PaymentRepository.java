package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.employee.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
