package bg.softuni.battleships.repository;

import bg.softuni.battleships.model.dtos.ShipDTO;
import bg.softuni.battleships.model.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {

   Optional<Ship> findByName(String name);

    List<Ship> findByUserId(long ownerId);
    List<Ship> findByUserIdNot(long ownerId);

    List<Ship> findByOrderByHealthAscNameDescPowerAsc();
}
