package server.api.insurance.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.api.insurance.customer.entity.CustomerManagement;

public interface CustomerManagementRepository extends JpaRepository<CustomerManagement,Integer> {
    boolean existsByID(String ID);
}
