package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Student extends Person{

    @Column(name = "average_grade")
    private double averageGrade;

    @Column
    private int attendance;

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @ManyToMany
    @JoinTable
    private Set<Course> courses;

    public Student() {
    }
}
