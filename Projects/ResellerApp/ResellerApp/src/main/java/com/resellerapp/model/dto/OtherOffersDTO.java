package com.resellerapp.model.dto;

import com.resellerapp.model.entity.ConditionNameEnum;
import com.resellerapp.model.entity.Offer;

import java.math.BigDecimal;

public class OtherOffersDTO extends MyOfferDTO{

    private String sellerUsername;

   public OtherOffersDTO(){

   }
    public OtherOffersDTO(Offer offer){
    super(offer);
    sellerUsername = offer.getCreatedBy().getUsername();
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public OtherOffersDTO setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
        return this;
    }


}
