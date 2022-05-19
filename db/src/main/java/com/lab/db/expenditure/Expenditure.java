package com.lab.db.expenditure;

import com.lab.db.nomenclature.Nomenclature;
import com.lab.db.order.Order;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="expenditures")
public class Expenditure {
    @Id
    @SequenceGenerator(name= "expenditures_id_seq", sequenceName="expenditures_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenditures_id_seq")
    private Integer id;
    public void setId(int new_id) { this.id = new_id; }
    public Integer getId() {
        return id;
    }

    @NotNull
    private BigDecimal expense;
    public BigDecimal getExpense() {
        return expense;
    }
    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }

    @ManyToOne
    @JoinColumn(name="nomenclature_id")
    private Nomenclature nomenclature;
    public Nomenclature getNomenclature() {
        return nomenclature;
    }
    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
}
