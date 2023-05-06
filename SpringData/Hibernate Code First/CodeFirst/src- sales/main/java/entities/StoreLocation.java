package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class StoreLocation extends BaseEntity{

    @Column
    private String locationName;

    @OneToMany
    @JoinColumn
    private Set<Sale> sales;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public StoreLocation() {
        this.sales = new HashSet<>();
    }
}
