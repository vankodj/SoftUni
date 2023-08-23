package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.model.entities.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    Offer addOfferDtoToOfferEntity(AddOfferDto addOfferDto);
}
