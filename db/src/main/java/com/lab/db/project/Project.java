package com.lab.db.project;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.lab.db.address.Address;
import com.lab.db.order.Order;

import java.util.List;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @SequenceGenerator(name= "projects_id_seq", sequenceName="projects_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_id_seq")
    private Integer id;
    public Integer getId() {
        return id;
    }

    @NotNull
    private int rooms;

    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;

    @OneToMany
    @JoinColumn(name="project_id")
    private List<Order> orders;
}
