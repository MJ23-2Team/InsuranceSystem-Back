package server.app.insurance.conduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.app.insurance.conduct.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education,Integer> {
}
