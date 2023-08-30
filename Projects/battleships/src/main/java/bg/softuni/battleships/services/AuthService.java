package bg.softuni.battleships.services;

import bg.softuni.battleships.model.dtos.UserRegistrationDTO;
import bg.softuni.battleships.model.entities.User;
import bg.softuni.battleships.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<User> byEmail = this.userRepository.findByEmail(userRegistrationDTO.getEmail());
        if (byEmail.isPresent()){
            return false;
        }
        Optional<User> byUsername = this.userRepository.findByUsername(userRegistrationDTO.getUsername());

        if (byUsername.isPresent()){
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
