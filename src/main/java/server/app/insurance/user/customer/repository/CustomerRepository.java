package server.app.insurance.user.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByName(String name);
}
