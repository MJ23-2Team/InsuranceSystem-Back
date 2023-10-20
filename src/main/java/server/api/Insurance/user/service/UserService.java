package server.api.insurance.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.user.dto.UserDTO;
import server.api.insurance.user.repository.UserRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDTO request) {
        userRepository.save(request);
    }

    public List<UserDTO> getUser() {return userRepository.findAll();}

    public void updateUser(UserDTO request) {
        userRepository.save(request);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}