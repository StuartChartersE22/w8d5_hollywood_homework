package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director extends BizPerson {

    private List<Film> films;

    public Director() {}

    public Director(String name, int bank) {
        super(name, bank);
    }


    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
