package server.api.insurance.contractManagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractManagementRepository extends JpaRepository<ContractManagementDto,Integer> {
}
