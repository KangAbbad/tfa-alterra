package com.alta.bootcamp.laundryapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserRequestDTO implements Serializable {
  private String name;
  private String email;
  private String phone;
}
