package server.app.insurance.intra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.intra.entity.SellGroup;

public interface SellGroupRepository extends JpaRepository<SellGroup,Integer> {
}
