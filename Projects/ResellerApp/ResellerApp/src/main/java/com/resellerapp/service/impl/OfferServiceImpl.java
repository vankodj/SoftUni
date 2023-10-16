package com.resellerapp.service.impl;

import com.resellerapp.config.LoggedUser;
import com.resellerapp.model.dto.BoughtOffersDTO;
import com.resellerapp.model.dto.MyOfferDTO;
import com.resellerapp.model.dto.OfferHomeDTO;
import com.resellerapp.model.dto.OtherOffersDTO;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    private final LoggedUser loggedUser;

    public OfferServiceImpl(OfferRepository offerRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public OfferHomeDTO getOffersForHomePage() {
        List<Offer> offers = offerRepository.findAll();
        List<MyOfferDTO> myOffers = new ArrayList<>();
        List<BoughtOffersDTO> boughtOffers = new ArrayList<>();
        List<OtherOffersDTO> otherOffers = new ArrayList<>();
        offers.stream().forEach(offer -> {
            if (offer.getCreatedBy().getUsername().equals(loggedUser.getUsername())){
                myOffers.add(new MyOfferDTO(offer));
            } else if (offer.getBoughtBy().getUsername().equals(loggedUser.getUsername())) {
                boughtOffers.add(new BoughtOffersDTO(offer));
            }
            else {
                otherOffers.add(new OtherOffersDTO(offer));
            }
        });

        return new OfferHomeDTO(myOffers,boughtOffers,otherOffers);
    }
}
