package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.employee.entity.Reward;

@Repository
public interface RewardRepository extends JpaRepository<Reward,Integer> {
}
