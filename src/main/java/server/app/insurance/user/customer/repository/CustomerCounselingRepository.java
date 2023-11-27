package server.app.insurance.user.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.customer.entity.CustomerCounseling;

@Repository
public interface CustomerCounselingRepository extends JpaRepository<CustomerCounseling,Integer> {
}
