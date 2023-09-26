package bg.softuni.security.config;

import bg.softuni.security.model.enums.UserRoleEnum;
import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.service.AppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder("",256,256,2);
    }

//    enable or disable static resources and login,home,registration pages
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers(PathRequest
                        .toStaticResources()
                        .atCommonLocations())
                .permitAll()
//                everyone can register and login
                .requestMatchers("/", "/users/login", "/users/register").permitAll()
//                pages for moderators
                .requestMatchers("/pages/moderators").hasRole(UserRoleEnum.MODERATOR.name())
//                pages for admins
                .requestMatchers("/pages/admins").hasRole(UserRoleEnum.ADMIN.name())
                .anyRequest().authenticated()
//                configuration of form login
             .and()
                .formLogin().loginPage("/users/login")
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
//                where to go when login successful
                .defaultSuccessUrl("/")
//                where to go when we have incorrect login
                .failureForwardUrl("/users/login-error")
             .and()
                .logout().logoutUrl("users/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");



    return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new AppUserDetailsService(userRepository);
    }

}
