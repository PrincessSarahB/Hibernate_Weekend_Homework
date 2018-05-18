package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="films")
public class Film {

    private int id;
    private String title;
    private Studio studio;
    private Director director;
    private Set<Actor> actors;

    public Film() {
    }

    public Film(int id, String title, Studio studio, Director director) {
        this.id = id;
        this.title = title;
        this.studio = studio;
        this.director = director;
        this.actors = new HashSet<Actor>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name  ="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name ="actors_films",
    joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)})
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
