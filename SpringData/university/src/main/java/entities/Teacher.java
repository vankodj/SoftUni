package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Teacher extends Person {

    @Column
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Teacher() {
    }

    @OneToMany(mappedBy = "teacher")
    @JoinTable
    private Set<Course> courses;

}
