package com.resellerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    @Column(nullable = false)
    @Length(min = 2,max = 50)
    private String description;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @NotNull
    @ManyToOne
    private Condition condition;

    public User getCreatedBy() {
        return createdBy;
    }

    public Offer setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public User getBoughtBy() {
        return boughtBy;
    }

    public Offer setBoughtBy(User boughtBy) {
        this.boughtBy = boughtBy;
        return this;
    }

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User boughtBy;

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Condition getCondition() {
        return condition;
    }

    public Offer setCondition(Condition condition) {
        this.condition = condition;
        return this;
    }
}
