package com.Sydorenko.dao;

import com.Sydorenko.model.OrderItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItems,Long> {
}
