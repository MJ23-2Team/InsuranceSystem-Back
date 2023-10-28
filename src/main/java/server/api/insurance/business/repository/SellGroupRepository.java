package server.api.insurance.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.api.insurance.business.entity.SellGroup;

public interface SellGroupRepository extends JpaRepository<SellGroup,Integer> {
}
