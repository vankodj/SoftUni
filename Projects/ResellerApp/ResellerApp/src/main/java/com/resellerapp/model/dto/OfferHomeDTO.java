package com.resellerapp.model.dto;

import java.util.List;

public class OfferHomeDTO {

    private List<MyOfferDTO> myOffers;

    private List<BoughtOffersDTO> boughtOffers;
    private List<OtherOffersDTO> allOtherOffers;

    private long totalOtherOffers;

    public List<MyOfferDTO> getMyOffers() {
        return myOffers;
    }

    public OfferHomeDTO setMyOffers(List<MyOfferDTO> myOffers) {
        this.myOffers = myOffers;
        return this;
    }

    public List<BoughtOffersDTO> getBoughtOffers() {
        return boughtOffers;
    }

    public OfferHomeDTO setBoughtOffers(List<BoughtOffersDTO> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }

    public List<OtherOffersDTO> getAllOtherOffers() {
        return allOtherOffers;
    }

    public OfferHomeDTO setAllOtherOffers(List<OtherOffersDTO> allOtherOffers) {
        this.allOtherOffers = allOtherOffers;
        return this;
    }

    public long getTotalOtherOffers() {
        return totalOtherOffers;
    }

    public OfferHomeDTO setTotalOtherOffers(long totalOtherOffers) {
        this.totalOtherOffers = totalOtherOffers;
        return this;
    }
}
