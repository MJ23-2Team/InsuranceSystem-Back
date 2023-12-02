package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.app.insurance.user.employee.dto.UserPersonaDto;
import server.app.insurance.user.employee.entity.UserPersona;

import java.util.List;

public interface UserPersonaRepository extends JpaRepository<UserPersona,Integer> {
    @Query("select new server.app.insurance.user.employee.dto.UserPersonaDto(sc.sex, sc.age, sc.job, sc.incomeLevel) " +
            "from UserPersona sc " +
            "where sc.insurance.insuranceID = :id")
    List<UserPersonaDto> findByInsuranceID(int id);
}
