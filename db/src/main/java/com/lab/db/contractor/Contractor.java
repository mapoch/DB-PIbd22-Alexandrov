package com.lab.db.contractor;

import com.lab.db.contractors_class.Contractors_class;
import com.lab.db.order.Order;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="contractors")
public class Contractor {
    @Id
    @SequenceGenerator(name= "contractors_id_seq", sequenceName="contractors_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contractors_id_seq")
    private Integer id;
    public Integer getId() {
        return id;
    }

    @NotNull
    @Size(max = 40)
    private String name;

    @Size(max = 15)
    private String phone;

    @OneToMany
    @JoinColumn(name="contractor_id")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name="class_id")
    private Contractors_class contractors_class;
}
