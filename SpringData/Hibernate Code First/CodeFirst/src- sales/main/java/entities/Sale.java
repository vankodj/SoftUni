package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Sale extends BaseEntity{

    @ManyToOne

    private Product product;

    @ManyToOne

    private Customer customer;

    @ManyToOne

    private StoreLocation storeLocation;

    @Column
    private Date date;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Sale() {
    }
}
