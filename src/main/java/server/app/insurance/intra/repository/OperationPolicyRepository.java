package server.app.insurance.intra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.intra.entity.OperationPolicy;

import java.util.List;

public interface OperationPolicyRepository extends JpaRepository<OperationPolicy,Integer> {

    List<OperationPolicy> findByPassLike (int pass);
}
