package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dtos.StartBattleDTO;
import bg.softuni.battleships.services.BattleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BattleController {


    private BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/battle")
    public String battle(@Valid StartBattleDTO startBattleDTO){
        System.out.println(startBattleDTO.getAttackerId() + " " + startBattleDTO.getDefenderId());
    this.battleService.attack(startBattleDTO){

        }
        return "redirect:/home";
    }
}
