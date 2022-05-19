package com.lab.db.expenditure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureRepository
        extends CrudRepository<Expenditure, Integer>, JpaRepository<Expenditure, Integer>{
}
