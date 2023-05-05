package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Customer extends BaseEntity{

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String creditCardNumber;

    @OneToMany
    @JoinColumn
    private Set<Sale> sales;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Customer() {
        this.sales = new HashSet<>();
    }
}
