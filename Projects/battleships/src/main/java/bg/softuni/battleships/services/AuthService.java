package bg.softuni.battleships.services;

import bg.softuni.battleships.model.dtos.UserRegistrationDTO;
import bg.softuni.battleships.model.entities.User;
import bg.softuni.battleships.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(UserRegistrationDTO userRegistrationDTO) {
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            return false;
        }


        User user = new User(
                userRegistrationDTO.getUsername(),
                userRegistrationDTO.getFullName(),
                userRegistrationDTO.getEmail(),
                userRegistrationDTO.getPassword());
        this.userRepository.save(user);
        return true;
    }
}
