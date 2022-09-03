package com.alta.bootcamp.laundryapp.repositories;

import com.alta.bootcamp.laundryapp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  Order getOrderById(Long id);
}
