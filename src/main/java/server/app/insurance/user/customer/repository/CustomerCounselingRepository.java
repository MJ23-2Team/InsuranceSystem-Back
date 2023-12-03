package server.app.insurance.user.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.customer.entity.CustomerCounseling;
import server.app.insurance.user.customer.dto.CustomerCounselingDto;
import server.app.insurance.user.customer.state.CounselingState;

import java.util.List;

@Repository
public interface CustomerCounselingRepository extends JpaRepository<CustomerCounseling,Integer> {
    @Query("select new server.app.insurance.user.customer.dto.CustomerCounselingDto(sc.counselingID, sc.counselingPlace, sc.counselingTime) " +
            "from CustomerCounseling sc " +
            "where sc.customer.customerID = :id and sc.counselingState = :state")
    List<CustomerCounselingDto> findByInsuranceID(int id, CounselingState state);
}
