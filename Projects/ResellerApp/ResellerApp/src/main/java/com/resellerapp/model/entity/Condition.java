package com.resellerapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="conditions")
public class Condition extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true,nullable = false)
    private ConditionNameEnum conditionName;

    @Column(nullable = false)
    private String description;

    public ConditionNameEnum getConditionName() {
        return conditionName;
    }

    public Condition setConditionName(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
        this.setCondition(conditionName);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Condition setDescription(String description) {
        this.description = description;
        return this;
    }
    public void setCondition(ConditionNameEnum name){
       String description = "";

        switch (name){
            case GOOD: description = "Some signs of wear and tear or minor defects";
            break;
            case EXCELLENT: description = "In perfect condition";
            break;
            case ACCEPTABLE: description = "The item is fairly worn but continues to function properly";
            break;
        }
        this.description = description;
    }

}
