package bg.softuni.security.config;

import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.service.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder("",256,256,2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity){
    return null;
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new AppUserDetailsService(userRepository);
    }

}
