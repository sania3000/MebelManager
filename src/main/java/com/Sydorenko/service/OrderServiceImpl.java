package com.Sydorenko.service;

import com.Sydorenko.dao.OrderRepository;
import com.Sydorenko.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;

    @Override
    public List<Orders> findAll () {
        return (List<Orders>) orderRepository.findAll();
    }

    @Override
    public Orders save ( Orders orders ) {
        return orderRepository.save(orders);
    }
}
