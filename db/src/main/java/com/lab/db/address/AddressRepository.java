package com.lab.db.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("address_repository")
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
