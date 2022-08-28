package com.alta.bootcamp.authapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class UserRequestDTO implements Serializable {
  @NotBlank
  @Size(max = 20)
  private String username;
  @NotBlank
  @Size(max = 16)
  private String phone;
  @NotBlank
  @Size(min = 5)
  private String password;
}
