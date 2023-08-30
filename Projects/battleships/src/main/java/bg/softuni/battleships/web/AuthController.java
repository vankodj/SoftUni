package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dtos.UserRegistrationDTO;
import bg.softuni.battleships.services.AuthService;
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

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initRegistrationDTO(){
        return new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO
            ,BindingResult bindingResult
            ,RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() || !authService.register(userRegistrationDTO)){
            redirectAttributes.addFlashAttribute("userRegistrationDTO",userRegistrationDTO);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.userRegistrationDTO"
                            ,bindingResult);

            return "redirect:/register";
        }


        return "redirect:/login";
    }
}
