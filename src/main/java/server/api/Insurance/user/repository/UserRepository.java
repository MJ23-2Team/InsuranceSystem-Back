package server.api.insurance.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.api.insurance.user.dto.UserDTO;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserDTO,Long> {
    @Override
    List<UserDTO> findAll();

    UserDTO findbyName();
}
