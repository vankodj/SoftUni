package bg.softuni.pathfinder.model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    private boolean approved;

    private LocalDateTime created;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;

    public Comment() {}

    public boolean isApproved() {
        return approved;
    }

    public Comment setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }
}
