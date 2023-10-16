package com.resellerapp.model.dto;

import com.resellerapp.model.entity.ConditionNameEnum;

import java.math.BigDecimal;

public class OtherOffersDTO {

    private String sellerUsername;

    private String description;

    private ConditionNameEnum condition;

    private BigDecimal price;

    public String getSellerUsername() {
        return sellerUsername;
    }

    public OtherOffersDTO setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OtherOffersDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public OtherOffersDTO setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OtherOffersDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
