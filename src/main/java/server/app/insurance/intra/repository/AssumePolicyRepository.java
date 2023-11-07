package server.app.insurance.intra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.app.insurance.intra.entity.AssumePolicy;

@Repository
public interface AssumePolicyRepository extends JpaRepository<AssumePolicy,Integer> {
}
