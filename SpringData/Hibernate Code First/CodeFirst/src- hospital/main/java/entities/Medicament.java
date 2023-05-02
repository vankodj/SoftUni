package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Medicament extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public Medicament() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 @ManyToMany
    private Set<Patient> patients;
}
