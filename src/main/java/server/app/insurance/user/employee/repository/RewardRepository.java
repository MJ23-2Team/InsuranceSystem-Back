package server.app.insurance.user.employee.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.app.insurance.common.util.Constants;
import server.app.insurance.user.employee.dto.RewardDto;
import server.app.insurance.user.employee.entity.Reward;

import java.util.Collection;
import java.util.List;

@Repository
public interface RewardRepository extends JpaRepository<Reward,Integer> {

    @Query("SELECT r FROM Reward r WHERE r.contract.contractID in :contractids")
    List<Reward> findAllByContractIds(@Param("contractids") Collection<Integer> contractids);
}