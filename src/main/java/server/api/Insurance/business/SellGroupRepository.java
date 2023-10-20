package server.api.insurance.business;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellGroupRepository extends JpaRepository<SellGroupDto,Integer> {
}
