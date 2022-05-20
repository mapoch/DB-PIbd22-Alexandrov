package com.lab.db.nomenclature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service("nomenclatureService")
public class NomenclatureService {
    @Autowired
    NomenclatureRepository nomenclatureRepository;

    @Transactional
    public Nomenclature findById(int id) {
        return nomenclatureRepository.findById(id).get();
    }

    @Transactional
    public Iterable<Nomenclature> findAll() {
        return nomenclatureRepository.findAll();
    }

    @Transactional
    public Integer create(Nomenclature nomenclature) {
        return nomenclatureRepository.save(nomenclature).getId();
    }

    @Transactional
    public void update(int id, Nomenclature nomenclature) {
        Nomenclature nomen = nomenclatureRepository.findById(id).get();
        nomen.setName(nomenclature.getName());
        nomenclatureRepository.save(nomen);
    }

    @Transactional
    public void delete(int id) {
        nomenclatureRepository.delete(nomenclatureRepository.findById(id).get());
    }
}
