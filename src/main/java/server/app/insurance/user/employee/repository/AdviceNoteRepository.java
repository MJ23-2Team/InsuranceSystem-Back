package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.employee.entity.AdviceNote;

import java.util.List;

@Repository
public interface AdviceNoteRepository extends JpaRepository<AdviceNote,Integer> {

    @Query( "SELECT a FROM AdviceNote a WHERE a.customer.customerID=:customerId" )
    List<AdviceNote> findByCustomerId( @Param("customerId") int customerId );
}
