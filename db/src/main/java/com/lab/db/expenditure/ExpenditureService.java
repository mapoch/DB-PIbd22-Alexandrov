package com.lab.db.expenditure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;

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
    public Integer create(Expenditure expenditure) {
        return expenditureRepository.save(expenditure).getId();
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

    @Transactional
    public Iterable<Expenditure> getSortedDown() {
        return expenditureRepository.sortDown();
    }

    @Transactional
    public Iterable<Expenditure> getHigherExpense(int exp) {
        return expenditureRepository.getHigher(exp);
    }

    @Transactional
    public Iterable<ResultSet> getGroupted() {
        return expenditureRepository.getGroupted();
    }
}
