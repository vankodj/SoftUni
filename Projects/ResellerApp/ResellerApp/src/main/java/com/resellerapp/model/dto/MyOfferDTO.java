package com.resellerapp.model.dto;

import com.resellerapp.model.entity.ConditionNameEnum;

import java.math.BigDecimal;

public class MyOfferDTO {

    private ConditionNameEnum condition;

    private String description;

    private BigDecimal price;

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public MyOfferDTO setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MyOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MyOfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
