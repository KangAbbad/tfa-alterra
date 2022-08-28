package com.alta.bootcamp.laundryapp.dto;

import com.alta.bootcamp.laundryapp.entities.LaundryServiceType;
import com.alta.bootcamp.laundryapp.entities.PaymentMethod;
import com.alta.bootcamp.laundryapp.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
  @JsonProperty("total_price")
  private BigDecimal totalPrice;
  @JsonIgnore
  private Date createdAt;
  @JsonIgnore
  private Date updatedAt;
}
