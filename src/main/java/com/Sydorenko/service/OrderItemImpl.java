package com.Sydorenko.service;

import com.Sydorenko.dao.OrderItemRepository;
import com.Sydorenko.dao.OrderRepository;
import com.Sydorenko.model.OrderItems;
import com.Sydorenko.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemImpl implements OrderItemService{
    OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItems> findAll () {
        return (List<OrderItems>) orderItemRepository.findAll();
    }



    @Override
    public OrderItems save ( OrderItems orderItems ) {
        return orderItemRepository.save(orderItems);
    }
}
