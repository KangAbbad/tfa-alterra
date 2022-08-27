package com.alta.bootcamp.laundryapp.services;

import com.alta.bootcamp.laundryapp.dto.OrderRequestDTO;
import com.alta.bootcamp.laundryapp.dto.OrderResponseDTO;
import com.alta.bootcamp.laundryapp.entities.LaundryServiceType;
import com.alta.bootcamp.laundryapp.entities.Order;
import com.alta.bootcamp.laundryapp.entities.PaymentMethod;
import com.alta.bootcamp.laundryapp.entities.User;
import com.alta.bootcamp.laundryapp.exceptions.ResourceNotFoundException;
import com.alta.bootcamp.laundryapp.exceptions.ValidationErrorException;
import com.alta.bootcamp.laundryapp.repositories.LaundryServiceTypeRepository;
import com.alta.bootcamp.laundryapp.repositories.OrderRepository;
import com.alta.bootcamp.laundryapp.repositories.PaymentMethodRepository;
import com.alta.bootcamp.laundryapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  LaundryServiceTypeRepository laundryServiceTypeRepository;
  @Autowired
  PaymentMethodRepository paymentMethodRepository;

  @Override
  public OrderResponseDTO createOrder(OrderRequestDTO request) {
    validate(request);
    Order order = convertToEntity(request);

    getOrderRelationById(request, order);

    Order createdOrder = orderRepository.save(order);
    return convertToDto(createdOrder);
  }

  @Override
  public List<OrderResponseDTO> getAllOrders() {
    List<Order> orders = orderRepository.findAll();
    if (orders.isEmpty()) return Collections.emptyList();
    return orders.stream()
      .map(order -> modelMapper.map(order, OrderResponseDTO.class))
      .collect(Collectors.toList());
  }

  @Override
  public OrderResponseDTO getOrder(Long id) {
    Order order = orderRepository.getOrderById(id);
    return convertToDto(order);
  }

  @Override
  public OrderResponseDTO updateOrder(OrderRequestDTO request, Long id) {
    validate(request);
    Optional<Order> findOrder = orderRepository.findById(id);
    if (findOrder.isPresent()) {
      Order tempOrder = findOrder.get();

      getOrderRelationById(request, tempOrder);

      tempOrder.setWeight(request.getWeight());
      tempOrder.setTotalPrice(request.getTotalPrice());

      Order convertToEntity = modelMapper.map(tempOrder, Order.class);
      Order updatedOrder = orderRepository.save(convertToEntity);

      return convertToDto(updatedOrder);
    } else {
      throw new ResourceNotFoundException("Order not found");
    }
  }

  @Override
  public String deleteOrder(Long id) {
    if (id == null) {
      throw new ValidationErrorException("ID cannot be empty");
    }

    Optional<Order> findOrder = orderRepository.findById(id);
    if (findOrder.isPresent()) {
      orderRepository.deleteById(id);
      return "ORDER ID: " + findOrder.get().getId() + " successfully deleted";
    } else {
      return "ORDER ID not found";
    }
  }

  private void getOrderRelationById(OrderRequestDTO request, Order order) {
    Optional<User> user = userRepository.findById(request.getUserId());
    if (user.isEmpty()) throw new ResourceNotFoundException("User not found");
    order.setUser(user.get());

    Optional<LaundryServiceType> serviceType = laundryServiceTypeRepository.findById(request.getServiceTypeId());
    if (serviceType.isEmpty()) throw new ResourceNotFoundException("Service type not found");
    order.setServiceType(serviceType.get());

    Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(request.getPaymentMethodId());
    if (paymentMethod.isEmpty()) throw new ResourceNotFoundException("Payment method not found");
    order.setPaymentMethod(paymentMethod.get());
  }

  private void validate(OrderRequestDTO request) {
    if (request == null) {
      throw new ValidationErrorException("Body request cannot be empty");
    }

    if (request.getUserId() == null) {
      throw new ValidationErrorException("User id cannot be empty");
    }

    if (request.getServiceTypeId() == null) {
      throw new ValidationErrorException("Service type id cannot be empty");
    }

    if (request.getPaymentMethodId() == null) {
      throw new ValidationErrorException("Payment method id cannot be empty");
    }

    if (request.getWeight() < 1) {
      throw new ValidationErrorException("Weight minimum is 1");
    }

    if (request.getTotalPrice() == null) {
      throw new ValidationErrorException("Total price cannot be empty");
    }
  }

  private Order convertToEntity(OrderRequestDTO request) {
    return modelMapper.map(request, Order.class);
  }

  private OrderResponseDTO convertToDto(Order order) {
    return modelMapper.map(order, OrderResponseDTO.class);
  }
}
