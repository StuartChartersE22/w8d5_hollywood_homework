package models;

import behaviours.IAct;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "actors")
public class Actor extends BizPerson implements IAct {

    private Map<String, Film> roles;
    private List<Film> films;

    public Actor(){}

    public Actor(String name, int bank){
        super(name, bank);
    }

    @ManyToMany
    @JoinTable(name = "films_acts",
            joinColumns = {@JoinColumn(name = "film_id",  nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "act_id",  nullable = false, updatable = false)})
    @MapKeyColumn(name = "role")
    private Map<String, Film> getRoles(){
        return this.roles;
    }
    public void setRoles(Map<String, Film> roles) {
        this.roles = roles;
    }
}
