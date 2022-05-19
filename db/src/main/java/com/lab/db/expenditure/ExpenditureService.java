package com.lab.db.expenditure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service("expenditureService")
public class ExpenditureService {
    @Autowired
    ExpenditureRepository expenditureRepository;

    @Transactional
    public Expenditure findById(int id) {
        return expenditureRepository.findById(id).get();
    }

    @Transactional
    public Iterable<Expenditure> findAll() {
        return expenditureRepository.findAll();
    }

    @Transactional
    public void create(Expenditure expenditure) {
        expenditureRepository.save(expenditure);
    }

    @Transactional
    public void update(int id, Expenditure expenditure) {
        Expenditure exp = expenditureRepository.findById(id).get();
        exp.setExpense(expenditure.getExpense());
        expenditureRepository.save(exp);
    }

    @Transactional
    public void delete(int id) {
        expenditureRepository.delete(expenditureRepository.findById(id).get());
    }
}
