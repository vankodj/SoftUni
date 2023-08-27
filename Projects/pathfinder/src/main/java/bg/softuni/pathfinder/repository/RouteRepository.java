package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    @Query("SELECT r FROM Route r ORDER BY size(r.comments) desc limit 1")
  Route findMostCommented();
}
