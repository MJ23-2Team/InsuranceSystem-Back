package server.api.insurance.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceNoteRepository extends JpaRepository<AdviceNote,Integer> {
}
