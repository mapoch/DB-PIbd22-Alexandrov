package com.lab.db.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRopository extends CrudRepository<Order, Integer>, JpaRepository<Order, Integer>{
}
