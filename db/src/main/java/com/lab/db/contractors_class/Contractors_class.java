package com.lab.db.contractors_class;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.lab.db.contractor.Contractor;

import java.util.List;

@Entity
@Table(name="contractors_classes")
public class Contractors_class {
    @Id
    @SequenceGenerator(name= "contractors_classes_id_seq", sequenceName="contractors_classes_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contractors_classes_id_seq")
    private Integer id;
    public Integer getId() {
        return id;
    }

    @NotNull
    @Size(max = 10)
    private String name;

    @OneToMany
    @JoinColumn(name="class_id")
    private List<Contractor> contractors;
}
