package bg.softuni.pathfinder.model.entities;

import bg.softuni.pathfinder.model.enums.RouteCategory;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RouteCategory name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {}

    public RouteCategory getName() {
        return name;
    }

    public Category setName(RouteCategory name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
