package com.lab.db.contractor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepository extends CrudRepository<Contractor, Integer>, JpaRepository<Contractor, Integer> {
}
