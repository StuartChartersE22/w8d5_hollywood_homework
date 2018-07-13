package models;

import behaviours.IAct;
import behaviours.IDB;

import javax.persistence.*;
import java.util.Map;

public class Film implements IDB {

    private int id;
    private String title;
    private Act leadingMan;
    private Act leadingLady;
    private Director director;
    private Map<IAct, String> cast;
    private int budget;
    private GenreType genre;
    private Studio studio;

    public Film(String title, Act leadingMan, Act leadingLady, Director director, int budget, GenreType genre, Studio studio) {
        this.title = title;
        this.leadingMan = leadingMan;
        this.leadingLady = leadingLady;
        this.director = director;
        this.budget = budget;
        this.genre = genre;
        this.studio = studio;
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
    @Column(name = "leading_man")
    public Act getLeadingMan() {
        return leadingMan;
    }
    public void setLeadingMan(Act leadingMan) {
        this.leadingMan = leadingMan;
    }

    @ManyToOne
    @Column(name = "leading_lady")
    public Act getLeadingLady() {
        return leadingLady;
    }
    public void setLeadingLady(Act leadingLady) {
        this.leadingLady = leadingLady;
    }

    @ManyToOne
    @Column(name = "director")
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }

    @ManyToMany
    public Map<IAct, String> getCast() {
        return cast;
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
    @Column(name = "production_studio")
    public Studio getStudio() {
        return studio;
    }
    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
