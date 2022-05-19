package com.lab.db.expenditure_item;

import com.lab.db.nomenclature.Nomenclature;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="expenditure_items")
public class Expenditure_item {
    @Id
    @SequenceGenerator(name= "expenditure_items_id_seq", sequenceName="expenditure_items_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenditure_items_id_seq")
    private Integer id;
    public void setId(int new_id) { this.id = new_id; }
    public Integer getId() {
        return id;
    }

    @NotNull
    @Size(max = 22)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn(name="expenditure_item_id")
    private List<Nomenclature> nomenclatures;
}
