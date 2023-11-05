package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.user.employee.entity.CampaignProgram;

public interface CampaignProgramRepository extends JpaRepository<CampaignProgram,Integer> {
}
