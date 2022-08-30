package com.alta.bootcamp.laundryapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PaymentMethodRequestDTO implements Serializable {
  private String name;
}
