package com.alexkirnsu.hexarch.inside.port;

import com.alexkirnsu.hexarch.inside.domain.Order;

public interface OrderDao {
    void save(int unitCount);
    Order get(int id);
}
