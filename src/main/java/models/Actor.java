package models;

import behaviours.IAct;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "actors")
public class Actor extends BizPerson implements IAct {

    private Map<Film, String> roles;

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
    @MapKeyColumn(name = "film_id")
    private Map<Film, String> getRoles(){
        return this.roles;
    }
    public void setRoles(Map<Film, String> roles) {
        this.roles = roles;
    }
}
