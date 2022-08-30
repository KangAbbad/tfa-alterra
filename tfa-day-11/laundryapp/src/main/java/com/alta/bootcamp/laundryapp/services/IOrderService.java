package com.alta.bootcamp.laundryapp.services;

import com.alta.bootcamp.laundryapp.dto.OrderRequestDTO;
import com.alta.bootcamp.laundryapp.dto.OrderResponseDTO;

import java.io.Serializable;
import java.util.List;

public interface IOrderService extends Serializable {
  OrderResponseDTO createOrder(OrderRequestDTO request);
  List<OrderResponseDTO> getAllOrders();
  OrderResponseDTO getOrder(Long id);
  OrderResponseDTO updateOrder(OrderRequestDTO request, Long id);
  String deleteOrder(Long id);
}
