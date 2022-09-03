package com.alta.bootcamp.laundryapp.controller;

import com.alta.bootcamp.laundryapp.dto.OrderRequestDTO;
import com.alta.bootcamp.laundryapp.dto.OrderResponseDTO;
import com.alta.bootcamp.laundryapp.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
  @Autowired
  IOrderService orderService;

  @PostMapping
  public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request) {
    OrderResponseDTO response = orderService.createOrder(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
    List<OrderResponseDTO> response = orderService.getAllOrders();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable("id") Long id) {
    OrderResponseDTO response = orderService.getOrder(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<OrderResponseDTO> updateOrder(@RequestBody OrderRequestDTO request, @PathVariable("id") Long id) {
    OrderResponseDTO response = orderService.updateOrder(request, id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
    String response = orderService.deleteOrder(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
