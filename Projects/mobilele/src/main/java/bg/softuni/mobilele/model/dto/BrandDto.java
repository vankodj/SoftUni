package bg.softuni.mobilele.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDto {

    private String name;

    public String getName() {
        return name;
    }

    public BrandDto setName(String name) {
        this.name = name;
        return this;
    }

    private List<ModelDto> models;

    public List<ModelDto> getModels() {
        return models;
    }

    public BrandDto setModels(List<ModelDto> models) {
        this.models = models;
        return this;
    }

    public BrandDto addModels(ModelDto model) {
        if (this.models == null){
            this.models = new ArrayList<>();
        }
        this.models.add(model);
        return this;
    }
}
