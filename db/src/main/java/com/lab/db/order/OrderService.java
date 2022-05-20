package com.lab.db.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Transactional
@Service("orderService")
public class OrderService {
    @Autowired
    OrderRopository orderRopository;

    @Transactional
    public Order findById(int id) {
        return orderRopository.findById(id).get();
    }

    @Transactional
    public Iterable<Order> findAll() {
        return orderRopository.findAll();
    }

    @Transactional
    public Integer create(Order order) {
        return orderRopository.save(order).getId();
    }

    @Transactional
    public void update(int id, Order order) {
        Order ord = orderRopository.findById(id).get();
        ord.setWorks_start(order.getWorks_start());
        ord.setWorks_end(order.getWorks_end());
        orderRopository.save(ord);
    }

    @Transactional
    public void delete(int id) {
        orderRopository.delete(orderRopository.findById(id).get());
    }

    @Transactional
    public Iterable<Order> getByYear(int year) {
        if(year >= 1000 && year < 9999) return orderRopository.getOrdersByYear(year);
        return new ArrayList<Order>();
    }
}
