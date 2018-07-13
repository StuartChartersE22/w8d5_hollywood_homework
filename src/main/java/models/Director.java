package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director extends BizPerson {

    private List<Film> films;

    public Director() {}

    public Director(String name, int bank) {
        super(name, bank);
    }

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
