package server.api.insurance.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.api.insurance.business.entity.AssumePolicy;

@Repository
public interface AssumePolicyRepository extends JpaRepository<AssumePolicy,Integer> {
}
