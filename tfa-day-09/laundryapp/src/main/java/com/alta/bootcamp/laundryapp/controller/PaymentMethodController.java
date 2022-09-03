package com.alta.bootcamp.laundryapp.controller;

import com.alta.bootcamp.laundryapp.dto.PaymentMethodRequestDTO;
import com.alta.bootcamp.laundryapp.dto.PaymentMethodResponseDTO;
import com.alta.bootcamp.laundryapp.services.IPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment-methods")
public class PaymentMethodController {
  @Autowired
  IPaymentMethodService paymentMethodService;

  @PostMapping
  public ResponseEntity<PaymentMethodResponseDTO> createPaymentMethod(@RequestBody PaymentMethodRequestDTO request) {
    PaymentMethodResponseDTO response = paymentMethodService.createPaymentMethod(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<PaymentMethodResponseDTO>> getAllPaymentMethods() {
    List<PaymentMethodResponseDTO> response = paymentMethodService.getAllPaymentMethods();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PaymentMethodResponseDTO> getPaymentMethod(@PathVariable("id") Long id) {
    PaymentMethodResponseDTO response = paymentMethodService.getPaymentMethod(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PaymentMethodResponseDTO> updatePaymentMethod(@RequestBody PaymentMethodRequestDTO request, @PathVariable("id") Long id) {
    PaymentMethodResponseDTO response = paymentMethodService.updatePaymentMethod(request, id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePaymentMethod(@PathVariable("id") Long id) {
    String response = paymentMethodService.deletePaymentMethod(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
