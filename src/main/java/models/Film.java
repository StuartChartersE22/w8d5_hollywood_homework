package models;

import behaviours.IAct;
import behaviours.IDB;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "films")
public class Film implements IDB {

    private int id;
    private String title;
    private Director director;
    private Map<IAct, String> cast;
    private int budget;
    private GenreType genre;
    private Studio studio;

    public Film(){}

    public Film(String title, Director director, int budget, GenreType genre, Studio studio) {
        this.title = title;
        this.director = director;
        this.budget = budget;
        this.genre = genre;
        this.studio = studio;
        this.cast = new HashMap<IAct, String>();
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

    @ManyToMany
    @JoinTable(
            name = "films_acts",
            joinColumns = {@JoinColumn(name = "act_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}
    )
    @MapKeyColumn(name = "act_id")
    public Map<IAct, String> getCast(){
        return this.cast;
    }
    public void setCast(Map<IAct, String> cast) {
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

    public void addCast(Map<IAct,String> cast) {
        this.cast.putAll(cast);
    }
}
