package com.lab.db.contractors_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service("contractor_classService")
public class Contractor_classService {
    @Autowired
    Contractors_classRepository contractor_classRepository;

    @Transactional
    public Contractors_class findById(int id) {
        return contractor_classRepository.findById(id).get();
    }

    @Transactional
    public Iterable<Contractors_class> findAll() {
        return contractor_classRepository.findAll();
    }

    @Transactional
    public Integer create(Contractors_class contractors_class) {
        return contractor_classRepository.save(contractors_class).getId();
    }

    @Transactional
    public void update(int id, Contractors_class contractors_class) {
        Contractors_class contr_class = contractor_classRepository.findById(id).get();
        contr_class.setName(contractors_class.getName());
        contractor_classRepository.save(contr_class);
    }

    @Transactional
    public void delete(int id) {
        contractor_classRepository.delete(contractor_classRepository.findById(id).get());
    }
}
