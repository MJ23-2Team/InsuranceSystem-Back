package server.api.insurance.contract;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDto,Integer> {
}
