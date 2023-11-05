package server.app.insurance.conduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.conduct.entity.OperationPolicy;

public interface OperationPolicyRepository extends JpaRepository<OperationPolicy,Integer> {
}
