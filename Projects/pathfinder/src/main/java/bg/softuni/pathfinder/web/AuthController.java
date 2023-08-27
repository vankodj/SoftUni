package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String register(Model model){
   model.addAttribute("userRegistrationDTO",new UserRegistrationDTO());
        return "/register";
    }

    @PostMapping("/register")
    public String doRegister(UserRegistrationDTO userRegistrationDTO){

        return "redirect:/register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
