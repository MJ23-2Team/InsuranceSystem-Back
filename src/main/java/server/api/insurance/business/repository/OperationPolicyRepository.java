package server.api.insurance.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.api.insurance.business.entity.OperationPolicy;

public interface OperationPolicyRepository extends JpaRepository<OperationPolicy,Integer> {
}
