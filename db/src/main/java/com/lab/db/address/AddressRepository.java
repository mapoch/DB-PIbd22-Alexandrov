package com.lab.db.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>, JpaRepository<Address, Integer> {
    @Modifying
    @Query(value = "SELECT * FROM addresses WHERE settlement LIKE ':settlement';", nativeQuery = true)
    Collection<Address> getAddressesBySettlement(@Param("settlement") String settlement);
}
