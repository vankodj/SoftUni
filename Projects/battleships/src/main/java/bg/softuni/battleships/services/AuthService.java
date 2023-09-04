package bg.softuni.battleships.services;

import bg.softuni.battleships.model.dtos.LoginDTO;
import bg.softuni.battleships.model.dtos.UserRegistrationDTO;
import bg.softuni.battleships.model.entities.User;
import bg.softuni.battleships.repository.UserRepository;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public AuthService(UserRepository userRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
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

  public boolean login(LoginDTO loginDTO){
        Optional<User> user = this.userRepository
                .findByUsernameAndPassword(loginDTO
                .getUsername(), loginDTO.getPassword());

  if (user.isEmpty()){
      return false;
  }
  this.userSession.login(user.get());
  return true;
  }

    public long getLoggedUserId() {
        return this.userSession.getId();
    }

    public boolean isLoggedIn() {
        return this.userSession.getId() >0;
    }

    public void logout() {
        this.userSession.logout();
    }
}
