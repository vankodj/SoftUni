package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Product extends BaseEntity{

   @Column
    private String name;

   @Column
    private double quantity;

   @Column
    private BigDecimal price;

   @OneToMany
   @JoinColumn
    private Set<Sale> sales;

    public Product() {
        this.sales = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
