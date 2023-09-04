package bg.softuni.battleships.services;

import bg.softuni.battleships.model.dtos.StartBattleDTO;
import bg.softuni.battleships.model.entities.Ship;
import bg.softuni.battleships.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {
    private ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void attack(StartBattleDTO attackData){
        Optional<Ship> attackerOpt = this.shipRepository.findById((long) attackData.getAttackerId());
        Optional<Ship> defenderOpt = this.shipRepository.findById((long) attackData.getDefenderId());
     if (attackerOpt.isEmpty() || defenderOpt.isEmpty()){
         throw new NoSuchElementException();
        }
     Ship attacker = attackerOpt.get();
     Ship defender = defenderOpt.get();

     long defenderHealthLeft = defender.getHealth() - attacker.getPower();
     if (defenderHealthLeft <= 0){
         this.shipRepository.delete(defender);
     }else{
         defender.setHealth(defenderHealthLeft);
         this.shipRepository.save(defender);
     }
    }
}
