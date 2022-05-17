package com.lab.db.address;

import com.lab.db.project.Project;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @SequenceGenerator(name= "adresses_id_seq", sequenceName="adresses_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adresses_id_seq")
    private Integer id;
    public void setId(int new_id) { this.id = new_id; }
    public Integer getId() {
        return id;
    }

    @NotNull
    @Size(max=20)
    private String settlement;
    public void setSettlement(String str) { this.settlement = str; }
    public String getSettlement() {return this.settlement;}

    @NotNull
    @Size(max=40)
    private String street;
    public void setStreet(String str) { this.street = str; }
    public String getStreet() {return this.street;}

    @NotNull
    private int house;
    public void setHouse(int numb) { this.house = numb; }
    public int getHouse() { return this.house; }

    @OneToMany
    @JoinColumn(name="address_id")
    private List<Project> projects;

    @Override
    public String toString() {
        return "[Id = " + getId() + "; settlement = \'" + getSettlement() +
                "\'; street = \'" + getStreet() + "\'; house = " + getHouse() + "]";
    }
}
