package models;

import behaviours.IDB;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studios")
public class Studio implements IDB {

    private int id;
    private String name;
    private int bank;
    private List<Film> films;

    public Studio(){}

    public Studio(String name, int bank){
        this.name = name;
        this.bank = bank;
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

    @Column(name = "bank")
    public int getBank() {
        return bank;
    }
    public void setBank(int bank) {
        this.bank = bank;
    }

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }
    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
