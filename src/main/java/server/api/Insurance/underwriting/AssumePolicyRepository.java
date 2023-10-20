package server.api.insurance.underwriting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssumePolicyRepository extends JpaRepository<AssumePolicyDto,Integer> {
}
