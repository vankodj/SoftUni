package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dtos.ShipDTO;
import bg.softuni.battleships.model.dtos.StartBattleDTO;
import bg.softuni.battleships.services.AuthService;
import bg.softuni.battleships.services.ShipService;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;

    private final LoggedUser loggedUser;
    private AuthService authService;

    @ModelAttribute("startBattleDTO")
    public StartBattleDTO initBattleDTO(){
        return new StartBattleDTO();
    }

    public HomeController(ShipService shipService, LoggedUser loggedUser, AuthService authService) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
        this.authService = authService;
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {
        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        long loggedUserId = this.authService.getLoggedUserId();

        List<ShipDTO> ownShips = this.shipService.getShipsOwnedBy(loggedUserId);
        List<ShipDTO> enemyShips = this.shipService.getShipsNotOwnedBy(loggedUserId);
        List<ShipDTO> sortedShips = this.shipService.getAllSorted();

        model.addAttribute("ownShips", ownShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("sortedShips", sortedShips);

        return "home";
    }

    @GetMapping("/")
    public String loggedOutIndex(){
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

}
