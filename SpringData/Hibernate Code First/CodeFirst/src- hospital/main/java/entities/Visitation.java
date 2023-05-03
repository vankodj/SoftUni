package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Visitation extends BaseEntity{

  @Column(nullable = false)
  private Date date;

  @Column
  private String comments;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Visitation() {
  }

  @ManyToOne
  @JoinColumn
  private Patient patient;
}
