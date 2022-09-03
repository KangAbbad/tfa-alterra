package com.alta.bootcamp.laundryapp.services;

import com.alta.bootcamp.laundryapp.dto.PaymentMethodRequestDTO;
import com.alta.bootcamp.laundryapp.dto.PaymentMethodResponseDTO;

import java.io.Serializable;
import java.util.List;

public interface IPaymentMethodService extends Serializable {
  PaymentMethodResponseDTO createPaymentMethod(PaymentMethodRequestDTO request);
  List<PaymentMethodResponseDTO> getAllPaymentMethods();
  PaymentMethodResponseDTO getPaymentMethod(Long id);
  PaymentMethodResponseDTO updatePaymentMethod(PaymentMethodRequestDTO request, Long id);
  String deletePaymentMethod(Long id);
}
