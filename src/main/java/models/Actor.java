package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor {
    private int id;
    private String name;
    private double bankAccount;
    private double fee;
    private Set<Film> films;

    public Actor() {
    }

    public Actor(String name, double bankAccount, double fee) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.fee = fee;
        this.films = new HashSet<Film>();
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "bank_account")
    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name ="actors_films",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)})
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public void addFilmToActor(Film film) {
        this.films.add(film);
    }

    @Column(name="fee")
    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
