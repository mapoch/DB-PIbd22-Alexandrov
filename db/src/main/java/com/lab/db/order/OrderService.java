package com.lab.db.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

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
    public void create(Order order) {
        orderRopository.save(order);
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
}
