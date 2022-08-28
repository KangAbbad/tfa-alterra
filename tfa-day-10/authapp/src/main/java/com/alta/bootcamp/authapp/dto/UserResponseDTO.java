package com.alta.bootcamp.authapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserResponseDTO implements Serializable {
  private Long id;
  private String username;
  private String phone;
  private String password;
  @JsonIgnore
  private Date createdAt;
  @JsonIgnore
  private Date updatedAt;
}
