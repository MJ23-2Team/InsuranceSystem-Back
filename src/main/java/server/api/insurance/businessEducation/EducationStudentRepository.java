package server.api.insurance.businessEducation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationStudentRepository extends JpaRepository<EducationStudent,Integer> {
}
