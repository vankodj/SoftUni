package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Patient extends BaseEntity{


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String address;

    @Column
    private String email;

    @Column(name = "data_of_birth")
    private Date dateOfBirth;

    @Column
    private String picture;

    @Column(name = "has_insurance")
    private boolean hasInsurance;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Medicament> medicaments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Diagnose> diagnoses;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Visitation> visitations;

    public Patient() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}
