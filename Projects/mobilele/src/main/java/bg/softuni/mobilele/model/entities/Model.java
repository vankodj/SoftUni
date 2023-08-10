package bg.softuni.mobilele.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String imageUrl;

    private int startYear;

    private int endYear;

    @ManyToOne
    private Brand brand;
}
