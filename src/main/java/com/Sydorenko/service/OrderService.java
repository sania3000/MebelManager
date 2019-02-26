package com.Sydorenko.service;

import com.Sydorenko.model.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll();
    Orders save(Orders orders);
}
