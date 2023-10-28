package server.api.insurance.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.api.insurance.employee.entity.AdviceNote;

@Repository
public interface AdviceNoteRepository extends JpaRepository<AdviceNote,Integer> {
}
