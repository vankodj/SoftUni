package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dtos.LoginDTO;
import bg.softuni.battleships.model.dtos.UserRegistrationDTO;
import bg.softuni.battleships.services.AuthService;
import bg.softuni.battleships.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private AuthService authService;


    public AuthController(AuthService authService, LoggedUser loggedUser) {
        this.authService = authService;

    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @ModelAttribute("loginDTO")
    public LoginDTO loginDTO() {
        return new LoginDTO();
    }

    @GetMapping("/register")
    public String register() {
        if (authService.isLoggedIn()){
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if (authService.isLoggedIn()){
            return "redirect:/home";
        }

        if (bindingResult.hasErrors() || ! authService.register(userRegistrationDTO)) {
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.userRegistrationDTO"
                            , bindingResult);

            return "redirect:/register";
        }


        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {

        if (authService.isLoggedIn()){
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if (authService.isLoggedIn()){
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.loginDTO"
                            , bindingResult);
            return "redirect:/login";
        }

        if (!this.authService.login(loginDTO)){
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials",true);
            return "redirect:/login";
        }
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(){

        if (!authService.isLoggedIn()){
            return "redirect:/home";
        }

        this.authService.logout();
        return "redirect:/";
    }

}