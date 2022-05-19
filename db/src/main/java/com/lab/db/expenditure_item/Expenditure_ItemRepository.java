package com.lab.db.expenditure_item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Expenditure_ItemRepository
        extends CrudRepository<Expenditure_item, Integer>, JpaRepository<Expenditure_item, Integer> {
}
