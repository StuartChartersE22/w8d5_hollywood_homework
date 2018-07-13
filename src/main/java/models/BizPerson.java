package models;

import behaviours.IDB;

import javax.persistence.*;

@Entity
@Table(name = "biz_people")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "profession")
public abstract class BizPerson implements IDB {

    private int id;
    private String name;
    private int bank;

    public BizPerson(){}

    public BizPerson(String name, int bank){
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
}
