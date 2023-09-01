package bg.softuni.battleships.services;

import bg.softuni.battleships.model.dtos.CreateShipDTO;
import bg.softuni.battleships.model.entities.Category;
import bg.softuni.battleships.model.entities.Ship;
import bg.softuni.battleships.model.entities.ShipType;
import bg.softuni.battleships.model.entities.User;
import bg.softuni.battleships.repository.CategoryRepository;
import bg.softuni.battleships.repository.ShipRepository;
import bg.softuni.battleships.repository.UserRepository;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final LoggedUser loggedUser;

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    public ShipService(ShipRepository shipRepository, LoggedUser loggedUser, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.loggedUser = loggedUser;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public boolean create(CreateShipDTO createShipDTO){
        Optional<Ship> byName = this.shipRepository.findByName(createShipDTO.getName());
        if (byName.isPresent()){
            return false;
        }

        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        ShipType type = switch (createShipDTO.getCategory()){
            case 0 -> ShipType.BATTLE;
            case 1 -> ShipType.CARGO;
            case 2 -> ShipType.PATROL;
            default -> ShipType.BATTLE;
        };
        Category category = this.categoryRepository.findByName(type);

        Ship ship = new Ship();
                 ship.setName(createShipDTO.getName());
                 ship.setPower(createShipDTO.getPower());
                 ship.setHealth(createShipDTO.getHealth());
                 ship.setCreated(createShipDTO.getCreated());
                 ship.setUser(owner.get());
                 ship.setCategory(category);

        this.shipRepository.save(ship);
        return true;
    }
}
