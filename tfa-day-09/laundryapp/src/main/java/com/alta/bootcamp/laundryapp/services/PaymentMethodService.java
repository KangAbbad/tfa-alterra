package com.alta.bootcamp.laundryapp.services;

import com.alta.bootcamp.laundryapp.dto.PaymentMethodRequestDTO;
import com.alta.bootcamp.laundryapp.dto.PaymentMethodResponseDTO;
import com.alta.bootcamp.laundryapp.entities.PaymentMethod;
import com.alta.bootcamp.laundryapp.exceptions.ResourceNotFoundException;
import com.alta.bootcamp.laundryapp.exceptions.ValidationErrorException;
import com.alta.bootcamp.laundryapp.repositories.PaymentMethodRepository;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentMethodService implements IPaymentMethodService {
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  PaymentMethodRepository paymentMethodRepository;

  @SneakyThrows
  @Override
  @Transactional
  public PaymentMethodResponseDTO createPaymentMethod(PaymentMethodRequestDTO request) {
    validate(request);
    PaymentMethod paymentMethod = convertToEntity(request);
    PaymentMethod createdPaymentMethod = paymentMethodRepository.save(paymentMethod);
    return convertToDto(createdPaymentMethod);
  }

  @Override
  public List<PaymentMethodResponseDTO> getAllPaymentMethods() {
    List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
    if (paymentMethods.isEmpty()) return Collections.emptyList();
    return paymentMethods.stream()
            .map(paymentMethod -> modelMapper.map(paymentMethod, PaymentMethodResponseDTO.class))
            .collect(Collectors.toList());
  }

  @Override
  public PaymentMethodResponseDTO getPaymentMethod(Long id) {
    PaymentMethod paymentMethod = paymentMethodRepository.getPaymentMethodById(id);
    return convertToDto(paymentMethod);
  }

  @Override
  public PaymentMethodResponseDTO updatePaymentMethod(PaymentMethodRequestDTO request, Long id) {
    validate(request);
    Optional<PaymentMethod> findPaymentMethod = paymentMethodRepository.findById(id);
    if (findPaymentMethod.isPresent()) {
      PaymentMethod tempPaymentMethod = findPaymentMethod.get();
      tempPaymentMethod.setName(request.getName());
      PaymentMethod convertToEntity = modelMapper.map(tempPaymentMethod, PaymentMethod.class);
      PaymentMethod updatedUser = paymentMethodRepository.save(convertToEntity);
      return convertToDto(updatedUser);
    } else {
      throw new ResourceNotFoundException("Payment method not found");
    }
  }

  @Override
  public String deletePaymentMethod(Long id) {
    Optional<PaymentMethod> findPaymentMethod = paymentMethodRepository.findById(id);
    if (findPaymentMethod.isPresent()) {
      paymentMethodRepository.deleteById(id);
      return findPaymentMethod.get().getName() + " successfully deleted";
    } else {
      return "Payment method not found";
    }
  }

  public void validate(PaymentMethodRequestDTO request) {
    if (request == null) {
      throw new ValidationErrorException("Body request cannot be empty");
    }

    if (StringUtils.isEmpty(request.getName())) {
      throw new ValidationErrorException("Name cannot be empty");
    }
  }

  public PaymentMethod convertToEntity(PaymentMethodRequestDTO request) {
    return modelMapper.map(request, PaymentMethod.class);
  }

  public PaymentMethodResponseDTO convertToDto(PaymentMethod paymentMethod) {
    return modelMapper.map(paymentMethod, PaymentMethodResponseDTO.class);
  }
}
