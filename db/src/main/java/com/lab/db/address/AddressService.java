package com.lab.db.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service("addressService")
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public Address findById(int id) {
        return addressRepository.findById(id).get();
    }

    @Transactional
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }

    @Transactional
    public void create(Address address) {
        addressRepository.save(address);
    }

    @Transactional
    public void update(int id, Address address) {
        Address addr = addressRepository.findById(id).get();
        addr.setSettlement(address.getSettlement());
        addr.setStreet(address.getStreet());
        addr.setHouse(address.getHouse());
        addressRepository.save(addr);
    }

    @Transactional
    public void delete(int id) {
        addressRepository.delete(addressRepository.findById(id).get());
    }
}
