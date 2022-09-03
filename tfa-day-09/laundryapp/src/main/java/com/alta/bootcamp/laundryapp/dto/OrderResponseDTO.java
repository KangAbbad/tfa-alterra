package com.alta.bootcamp.laundryapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Getter
@Setter
public class OrderResponseDTO implements Serializable {
  private Long id;
  private UserResponseDTO user;
  private LaundryServiceTypeResponseDTO serviceType;
  private PaymentMethodResponseDTO paymentMethod;
  private int weight;
  private BigDecimal totalPrice;
  @JsonIgnore
  private Date createdAt;
  @JsonIgnore
  private Date updatedAt;
}
