package bg.softuni.mobilele.model.entities;

import bg.softuni.mobilele.model.enums.UserAdmin;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserAdmin userAdmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAdmin getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(UserAdmin userAdmin) {
        this.userAdmin = userAdmin;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userAdmin=" + userAdmin +
                '}';
    }
}
