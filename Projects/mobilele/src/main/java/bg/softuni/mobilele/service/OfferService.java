package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.model.dto.BrandDto;
import bg.softuni.mobilele.model.entities.Model;
import bg.softuni.mobilele.model.entities.Offer;
import bg.softuni.mobilele.model.entities.User;
import bg.softuni.mobilele.model.mapper.OfferMapper;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelRepository modelRepository;

    public OfferService(OfferRepository offerRepository
    , OfferMapper offerMapper
    , UserRepository userRepository
    , CurrentUser currentUser
    , ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }

    public void addOffer(AddOfferDto addOfferDto){

   Offer newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDto);
  User seller = userRepository.findByEmail(currentUser.getEmail()).orElseThrow();
  Model model = modelRepository.findById(addOfferDto.getModelId()).orElseThrow();
  newOffer.setModel(model);
  newOffer.setSeller(seller);
  offerRepository.save(newOffer);
    }


}
