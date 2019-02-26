package com.Sydorenko.dao;

import com.Sydorenko.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders,Long> {


}
