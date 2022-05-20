package com.lab.db.expenditure_item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service("expenditure_itemService")
public class Expenditure_itemService {
    @Autowired
    Expenditure_ItemRepository expenditure_itemRepository;

    @Transactional
    public Expenditure_item findById(int id) {
        return expenditure_itemRepository.findById(id).get();
    }

    @Transactional
    public Iterable<Expenditure_item> findAll() {
        return expenditure_itemRepository.findAll();
    }

    @Transactional
    public Integer create(Expenditure_item expenditure_item) {
        return expenditure_itemRepository.save(expenditure_item).getId();
    }

    @Transactional
    public void update(int id, Expenditure_item expenditure_item) {
        Expenditure_item exp_item = expenditure_itemRepository.findById(id).get();
        exp_item.setName(expenditure_item.getName());
        expenditure_itemRepository.save(exp_item);
    }

    @Transactional
    public void delete(int id) {
        expenditure_itemRepository.delete(expenditure_itemRepository.findById(id).get());
    }
}
