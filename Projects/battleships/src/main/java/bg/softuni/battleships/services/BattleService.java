package bg.softuni.battleships.services;

import bg.softuni.battleships.model.dtos.StartBattleDTO;
import bg.softuni.battleships.model.entities.Ship;
import bg.softuni.battleships.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BattleService {
    private ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void attack(StartBattleDTO attackData){
        Optional<Ship> attacker = this.shipRepository.findById((long) attackData.getAttackerId());
        Optional<Ship> defender = this.shipRepository.findById((long) attackData.getDefenderId());
     if (attacker.isEmpty()) || defender.isEmpty(){
         
        }
    }
}
