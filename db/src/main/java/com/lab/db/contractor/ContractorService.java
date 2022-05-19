package com.lab.db.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service("contractorService")
public class ContractorService {
    @Autowired
    ContractorRepository contractorRepository;

    @Transactional
    public Contractor findById(int id) {
        return contractorRepository.findById(id).get();
    }

    @Transactional
    public Iterable<Contractor> findAll() {
        return contractorRepository.findAll();
    }

    @Transactional
    public void create(Contractor contractor) {
        contractorRepository.save(contractor);
    }

    @Transactional
    public void update(int id, Contractor contractor) {
        Contractor contr = contractorRepository.findById(id).get();
        contr.setName(contractor.getName());
        contr.setPhone(contractor.getPhone());
        contractorRepository.save(contr);
    }

    @Transactional
    public void delete(int id) {
        contractorRepository.delete(contractorRepository.findById(id).get());
    }
}
