package com.lab.db.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service("addressService")
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public Address findById(int id) {
        return addressRepository.findById(id).get();
    }

    @Transactional
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }

    @Transactional
    public Integer create(Address address) {
        return addressRepository.save(address).getId();
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

    @Transactional
    public Iterable<Address> getBySettlement(String settlement) {
        return addressRepository.getAddressesBySettlement(settlement);
    }
}
