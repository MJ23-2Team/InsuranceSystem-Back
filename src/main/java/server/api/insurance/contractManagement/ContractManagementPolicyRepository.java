package server.api.insurance.contractManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractManagementPolicyRepository extends JpaRepository<ContractManagementPolicy,Integer> {
}
