package server.app.insurance.intra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.intra.entity.OperationPolicy;

public interface OperationPolicyRepository extends JpaRepository<OperationPolicy,Integer> {
}
