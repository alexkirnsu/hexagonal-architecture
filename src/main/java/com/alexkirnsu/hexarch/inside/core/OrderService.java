package com.alexkirnsu.hexarch.inside.core;

import com.alexkirnsu.hexarch.inside.domain.Order;
import com.alexkirnsu.hexarch.inside.port.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static int MAJOR_UNIT_CUTOFF = 1000;

    @Autowired
    private OrderDao dao;

    public void create(int unitCount) {
        dao.save(unitCount);
    }

    public boolean isMajor(int id) {
        Order order = getById(id);
        return order.getUnitCount() > MAJOR_UNIT_CUTOFF;
    }

    public Order getById(int id) {
        return dao.get(id);
    }
}
