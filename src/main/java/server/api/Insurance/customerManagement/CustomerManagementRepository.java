package server.api.insurance.customerManagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerManagementRepository extends JpaRepository<CustomerManagementDto,Integer> {
}
