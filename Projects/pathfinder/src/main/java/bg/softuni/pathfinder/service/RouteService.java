package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.entities.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented(){
    return routeRepository.findMostCommented();
    }
}
