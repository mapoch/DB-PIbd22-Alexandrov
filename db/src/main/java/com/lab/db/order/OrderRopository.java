package com.lab.db.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Repository
public interface OrderRopository extends CrudRepository<Order, Integer>, JpaRepository<Order, Integer>{
    @Modifying
    @Query(value = "SELECT * FROM orders " +
            "WHERE date_part('year', works_end) = :year ", nativeQuery = true)
    Collection<Order> getOrdersByYear(@Param("year") int year);
}
