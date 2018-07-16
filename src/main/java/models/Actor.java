package models;

import behaviours.IAct;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "actors")
public class Actor extends BizPerson{ //implements IAct {

    private Map<Film, String> roles;
    private List<Film> films;

    public Actor(){}

    public Actor(String name, int bank){
        super(name, bank);
    }

    @ManyToMany
    @JoinTable(
            name = "films_acts",
            joinColumns = {@JoinColumn(name = "film_id",  nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "act_id",  nullable = false, updatable = false)}
    )
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

//    @ManyToMany
//    @JoinTable(name = "films_acts")
//    @MapKeyColumn(name = "film_id")
//    private Map<Film, String> getRoles(){
//        return this.roles;
//    }
//    public void setRoles(Map<Film, String> roles) {
//        this.roles = roles;
//    }
}
