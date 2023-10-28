package server.api.insurance.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.api.insurance.employee.entity.CampaignProgram;

public interface CampaignProgramRepository extends JpaRepository<CampaignProgram,Integer> {
}
