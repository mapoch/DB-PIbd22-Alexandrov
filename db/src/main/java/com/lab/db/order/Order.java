package com.lab.db.order;

import com.lab.db.contractor.Contractor;
import com.lab.db.expenditure.Expenditure;
import com.lab.db.project.Project;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @SequenceGenerator(name= "orders_id_seq", sequenceName="orders_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id_seq")
    private Integer id;
    public Integer getId() {
        return id;
    }

    @NotNull
    private Date works_start;

    private Date works_end;

    @ManyToOne
    @JoinColumn(name="contractor_id")
    private Contractor contractor;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project projects;

    @OneToMany
    @JoinColumn(name="order_id")
    private List<Expenditure> expenditures;
}
