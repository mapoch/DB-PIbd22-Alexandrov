package com.lab.db.contractors_class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contractors_classRepository
        extends CrudRepository<Contractors_class,Integer>, JpaRepository<Contractors_class, Integer> {
}
