package server.api.insurance.underwriting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssumePolicyRepository extends JpaRepository<AssumePolicy,Integer> {
}
