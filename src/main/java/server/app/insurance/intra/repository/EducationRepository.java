package server.app.insurance.intra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.app.insurance.intra.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education,Integer> {
}
