package bg.softuni.pathfinder.model.entities;

import bg.softuni.pathfinder.model.enums.UserRoles;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

@Enumerated(EnumType.STRING)
    private UserRoles name;


    public Role() {
    }

    public UserRoles getName() {
        return name;
    }

    public Role setName(UserRoles name) {
        this.name = name;
        return this;
    }
}
