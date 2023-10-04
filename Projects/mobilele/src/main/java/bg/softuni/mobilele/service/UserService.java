package bg.softuni.mobilele.service;


import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entities.User;
import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private UserRepository userRepository;
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository,
                       CurrentUser currentUser,
                       PasswordEncoder passwordEncoder,
                       UserMapper userMapper){
      this.userRepository = userRepository;
      this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public void registerAndLogin(UserRegisterDto userRegisterDto){

       User newUser = userMapper.userDtoToUserEntity(userRegisterDto);
       newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userRepository.save(newUser);
       login(newUser);


    }
    public boolean login(UserLoginDto loginDto){
    Optional<User> userOpt = userRepository.findByEmail(loginDto.getUsername());
    if (userOpt.isEmpty()){
        LOGGER.info("User with name [{}] not found",loginDto.getUsername());
    }
    String rawPassword = loginDto.getPassword();
    String  encodedPassword = userOpt.get().getPassword();
    boolean success = passwordEncoder.matches(rawPassword,encodedPassword);
    if(success){
     login(userOpt.get());
    }else{
     logout();
    }
    return success;
    }


    private void login(User user){
    currentUser.setLoggedIn(true);
    currentUser.setName(user.getFirstName() + " " + user.getLastName());
    currentUser.setEmail(user.getEmail());

    }
    public void logout(){
    currentUser.clear();
    }

}
