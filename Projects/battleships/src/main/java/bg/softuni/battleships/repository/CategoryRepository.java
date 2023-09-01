package bg.softuni.battleships.repository;

import bg.softuni.battleships.model.entities.Category;
import bg.softuni.battleships.model.entities.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findByName(ShipType type);
}
