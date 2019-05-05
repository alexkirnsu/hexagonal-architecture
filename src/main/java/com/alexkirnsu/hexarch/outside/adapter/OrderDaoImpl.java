package com.alexkirnsu.hexarch.outside.adapter;

import com.alexkirnsu.hexarch.inside.domain.Order;
import com.alexkirnsu.hexarch.inside.port.OrderDao;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(int unitCount) {
        Order order = new Order();
        order.setUnitCount(unitCount);
        em.persist(order);
    }

    @Override
    public Order get(int id) {
        return em.find(Order.class, id);
    }
}
