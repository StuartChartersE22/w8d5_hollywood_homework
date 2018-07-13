package models;

import behaviours.IAct;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "acts")
public class Act extends BizPerson implements IAct {

    private Map<Film, Role> roles;
    private Boolean isMale;

    public Act(){}

    public Act(String name, int bank, boolean isMale){
        super(name, bank);
        this.isMale = isMale;
    }

    public void setRoles(Map<Film, String> roles) {

    }
}
