package com.lab.db.contractor;

import com.lab.db.address.Address;
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
    public void setId(int new_id) { this.id = new_id; }
    public Integer getId() {
        return id;
    }

    @NotNull
    @Size(max = 40)
    private String name;
    public void setName(String name) {this.name = name;}
    public String getName() {
        return name;
    }

    @Size(max = 15)
    private String phone;
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany
    @JoinColumn(name="contractor_id")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name="class_id")
    private Contractors_class contractors_class;

    @Override
    public String toString() {
        return "{\"name\": \"" + getName() +
                "\", \"phone\": \"" + getPhone() + "\"}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if (((Contractor)obj).getId() != this.getId() ||
                ((Contractor) obj).getName() != this.getName() || ((Contractor) obj).getPhone() != this.getPhone())
            return false;
        return true;
    }
}
