package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.enums.EngineType;
import bg.softuni.mobilele.model.enums.Transmission;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddOfferDto {

    @NotNull
    private EngineType engine;
    @NotNull
    private Transmission transmission;

    @NotEmpty
    private String imageUrl;



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }


    public Transmission getTransmission() {
        return transmission;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
