package com.alexkirnsu.hexarch;

import com.alexkirnsu.hexarch.inside.core.OrderService;
import com.alexkirnsu.hexarch.inside.domain.Order;
import com.alexkirnsu.hexarch.inside.port.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @InjectMocks
    private OrderService service;

    @Mock
    private OrderDao dao;

    @Test
    public void whenUnitCountGreaterThenHundred_thenOrderIsMajor() {
        Order majorOrder = new Order();
        majorOrder.setUnitCount(1001);
        doReturn(majorOrder).when(dao).get(1);

        assertEquals(true, service.isMajor(1));
    }

    @Test
    public void whenUnitCountLessThenHundred_thenOrderIsNotMajor() {
        Order notMajorOrder = new Order();
        notMajorOrder.setUnitCount(1000);
        doReturn(notMajorOrder).when(dao).get(1);

        assertEquals(false, service.isMajor(1));
    }
}
