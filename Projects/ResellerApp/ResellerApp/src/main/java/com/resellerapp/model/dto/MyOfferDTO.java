package com.resellerapp.model.dto;

import com.resellerapp.model.entity.ConditionNameEnum;
import com.resellerapp.model.entity.Offer;

import java.math.BigDecimal;

public class MyOfferDTO extends BoughtOffersDTO {

    private ConditionNameEnum condition;


    public ConditionNameEnum getCondition() {
        return condition;
    }

    public MyOfferDTO() {
    }
    public MyOfferDTO(Offer offer) {
       super(offer);
        condition = offer.getCondition().getConditionName();

    }

    public MyOfferDTO setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }


}
