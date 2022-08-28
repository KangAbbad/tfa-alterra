package com.alta.bootcamp.authapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequestDTO {
  @NotBlank
  @JsonProperty("phone")
  private String usernameOrPhone;
  @NotBlank
  private String password;
}
