package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.app.insurance.user.employee.entity.UserPersona;

public interface UserPersonaRepository extends JpaRepository<UserPersona,Integer> {

}
