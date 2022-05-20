package com.lab.db.nomenclature;

import com.lab.db.expenditure.Expenditure;
import com.lab.db.expenditure_item.Expenditure_item;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="nomenclatures")
public class Nomenclature {
    @Id
    @SequenceGenerator(name= "nomenclatures_id_seq", sequenceName="nomenclatures_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nomenclatures_id_seq")
    private Integer id;
    public void setId(int new_id) { this.id = new_id; }
    public Integer getId() {
        return id;
    }

    @NotNull
    @Size(max = 30)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="expenditure_item_id")
    private Expenditure_item expenditure_item;

    @OneToMany
    @JoinColumn(name="nomenclature_id")
    private List<Expenditure> expenditures;

    @Override
    public String toString() {
        return "[Id = " + getId() + "; name = \'" + getName() + "\']";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if (((Nomenclature)obj).getId() != this.getId() || ((Nomenclature) obj).getName() != this.getName())
            return false;
        return true;
    }
}
