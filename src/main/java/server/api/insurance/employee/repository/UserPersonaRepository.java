package server.api.insurance.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.api.insurance.employee.entity.UserPersona;

public interface UserPersonaRepository extends JpaRepository<UserPersona,Integer> {
}
