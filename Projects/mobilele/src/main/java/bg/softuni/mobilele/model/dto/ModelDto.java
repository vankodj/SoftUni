package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.entities.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelDto {

private Long id;

private String name;

    public Long getId() {
        return id;
    }

    public ModelDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelDto setName(String name) {
        this.name = name;
        return this;
    }
}
