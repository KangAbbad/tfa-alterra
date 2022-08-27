package com.alta.bootcamp.laundryapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class LaundryServiceTypeRequestDTO implements Serializable {
  private String name;
  private String description;
  private BigDecimal price;
}
