package server.app.insurance.intra.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.app.insurance.intra.entity.EducationStudent;

import java.util.List;

@Repository
public interface EducationStudentRepository extends JpaRepository<EducationStudent,Integer> {

    @Query( "SELECT e FROM EducationStudent e WHERE e.education.educationID=:id")
    List<EducationStudent> findByEducationId(@Param("id") int id );
}
