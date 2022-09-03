package com.alta.bootcamp.laundryapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Getter
@Setter
public class PaymentMethodResponseDTO {
  private Long id;
  private String name;

  @JsonIgnore
  private Date createdAt;
  @JsonIgnore
  private Date updatedAt;
}
