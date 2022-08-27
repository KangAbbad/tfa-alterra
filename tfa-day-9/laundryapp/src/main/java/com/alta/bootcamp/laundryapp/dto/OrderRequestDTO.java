package com.alta.bootcamp.laundryapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class OrderRequestDTO implements Serializable {
  @JsonProperty("user_id")
  private Long userId;
  @JsonProperty("service_type_id")
  private Long serviceTypeId;
  @JsonProperty("payment_method_id")
  private Long paymentMethodId;
  private int weight;
  @JsonProperty("total_price")
  private BigDecimal totalPrice;
}
