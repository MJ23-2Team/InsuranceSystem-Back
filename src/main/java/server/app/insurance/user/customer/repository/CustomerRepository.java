package server.app.insurance.user.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.customer.entity.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByName(String name);

    @Query("select m from Customer m where m.email = :email")
    Optional<Customer> findByEmailonToken(@Param("email") String email);

    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);
}
