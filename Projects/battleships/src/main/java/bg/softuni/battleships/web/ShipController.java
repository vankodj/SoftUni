package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dtos.CreateShipDTO;
import bg.softuni.battleships.services.AuthService;
import bg.softuni.battleships.services.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    private final ShipService shipService;
    private final AuthService authService;

    public ShipController(ShipService shipService, AuthService authService) {
        this.shipService = shipService;
        this.authService = authService;
    }

    @ModelAttribute("createShipDTO")
    public CreateShipDTO initCreateShipDTO(){
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String ships(){
        if (!authService.isLoggedIn()){
            return "redirect:/home";
        }

        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String ships(@Valid CreateShipDTO createShipDTO
                        , BindingResult bindingResult
                        , RedirectAttributes redirectAttributes){
      if (bindingResult.hasErrors() || this.shipService.create(createShipDTO)){
          redirectAttributes.addFlashAttribute("createShipDTO", createShipDTO);
          redirectAttributes.addFlashAttribute(
                  "org.springframework.validation.BindingResult.createShipDTO", bindingResult);

          return "redirect:/ships/add";
      }
     return "redirect:/home";
    }

}
