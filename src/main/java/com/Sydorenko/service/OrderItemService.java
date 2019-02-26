package com.Sydorenko.service;

import com.Sydorenko.model.OrderItems;
import com.Sydorenko.model.Orders;

import java.util.List;

public interface OrderItemService {

    List<OrderItems> findAll();
    OrderItems save(OrderItems orderItems);


}
