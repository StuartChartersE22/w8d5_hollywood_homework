package models;

import behaviours.IAct;
import behaviours.IDB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "films")
public class Film implements IDB {

    private int id;
    private String title;
    private Director director;
    private Map<String, Actor> cast;
    private int budget;
    private GenreType genre;
    private Studio studio;
    private List<Actor> actors;

    public Film(){}

    public Film(String title, Director director, int budget, GenreType genre, Studio studio) {
        this.title = title;
        this.director = director;
        this.budget = budget;
        this.genre = genre;
        this.studio = studio;
        this.cast = new HashMap<String, Actor>();
        this.actors = new ArrayList<Actor>();
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }

//    @ManyToMany
//    @JoinTable(
//            name = "films_acts",
//            joinColumns = {@JoinColumn(name = "act_id", nullable = false, updatable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}
//    )
//    public List<IAct> getActors() {
//        return actors;
//    }
//    public void setActors(List<IAct> actors) {
//        this.actors = actors;
//    }

    @ManyToMany
    @JoinTable(
            name = "films_acts",joinColumns = {@JoinColumn(name = "act_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}
    )
    @MapKeyColumn(name = "role")
    public Map<String, Actor> getCast(){
        return this.cast;
    }
    public void setCast(Map<String, Actor> cast) {
        this.cast = cast;
    }

    @Column(name = "budget")
    public int getBudget() {
        return budget;
    }
    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Enumerated(value = EnumType.STRING)
    public GenreType getGenre() {
        return genre;
    }
    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }
    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public void addCast(Map<String, Actor> cast) {
        this.actors.addAll(cast.values());
        this.cast.putAll(cast);
    }
}
