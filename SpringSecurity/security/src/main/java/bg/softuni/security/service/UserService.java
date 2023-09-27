package bg.softuni.security.service;

import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.model.enums.UserRoleEnum;
import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.repository.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void init(){
     if (userRepository.count() == 0 && userRoleRepository.count() == 0){
         UserRoleEntity adminRole = new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN);
         UserRoleEntity moderatorRole = new UserRoleEntity().setUserRole(UserRoleEnum.MODERATOR);
         adminRole = userRoleRepository.save(adminRole);
         moderatorRole = userRoleRepository.save(moderatorRole);

         initAdmin(List.of(adminRole,moderatorRole));
         initModerator(List.of(moderatorRole));
         initUser(List.of());
     }
    }
    private void initAdmin(List<UserRoleEntity> roles){
        UserEntity admin = new UserEntity()
                .setUserRoles(roles)
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setEmail("admin@example.com")
                .setPassword(passwordEncoder.encode("master"));
        userRepository.save(admin);

    }
    private void initModerator(List<UserRoleEntity> roles){
        UserEntity moderator = new UserEntity()
                .setUserRoles(roles)
                .setFirstName("Moderator")
                .setLastName("Moderatorov")
                .setEmail("moderator@example.com")
                .setPassword(passwordEncoder.encode("master"));

        userRepository.save(moderator);

    }
    private void initUser(List<UserRoleEntity> roles){
        UserEntity user = new UserEntity()
                .setUserRoles(roles)
                .setFirstName("User")
                .setLastName("Userov")
                .setEmail("user@example.com")
                .setPassword(passwordEncoder.encode("master"));

        userRepository.save(user);

    }

}
