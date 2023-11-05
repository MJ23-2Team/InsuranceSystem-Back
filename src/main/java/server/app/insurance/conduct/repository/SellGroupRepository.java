package server.app.insurance.conduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.conduct.entity.SellGroup;

public interface SellGroupRepository extends JpaRepository<SellGroup,Integer> {
}
