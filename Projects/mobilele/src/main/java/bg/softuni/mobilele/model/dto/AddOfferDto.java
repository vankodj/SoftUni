package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.enums.EngineType;
import bg.softuni.mobilele.model.enums.Transmission;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddOfferDto {
    @NotNull
    @Positive
    private Long modelId;

    @NotNull
    private EngineType engine;

    @NotNull
    @Positive
    private Integer price;

    @Min(1980)
    @NotNull
    private Integer year;

    @NotEmpty
    private String description;
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
    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }
}
