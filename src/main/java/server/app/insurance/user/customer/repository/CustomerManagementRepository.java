package server.app.insurance.user.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.user.customer.entity.CustomerManagement;

public interface CustomerManagementRepository extends JpaRepository<CustomerManagement,Integer> {
    boolean existsByID(String ID);
}
