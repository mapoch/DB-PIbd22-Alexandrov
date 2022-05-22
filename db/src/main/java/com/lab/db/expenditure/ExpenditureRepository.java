package com.lab.db.expenditure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.SqlResultSetMapping;
import java.sql.ResultSet;
import java.util.Collection;

@Repository
public interface ExpenditureRepository
        extends CrudRepository<Expenditure, Integer>, JpaRepository<Expenditure, Integer>{
    @Query(value = "SELECT * FROM expenditures ORDER BY expense DESC;", nativeQuery = true)
    Collection<Expenditure> sortDown();

    @Modifying
    @Query(value = "SELECT * FROM expenditures WHERE expense >= :exp", nativeQuery = true)
    Collection<Expenditure> getHigher(@Param("exp") int exp);

    @Modifying
    @Query(value = "SELECT expense, COUNT(*) FROM expenditures GROUP BY expense;", nativeQuery = true)
    Collection<ResultSet> getGroupted();
}
