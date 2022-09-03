package com.alta.bootcamp.laundryapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Getter
@Setter
public class UserResponseDTO implements Serializable {
  private Long id;
  private String name;
  private String email;
  private String phone;

  @JsonIgnore
  private Date createdAt;
  @JsonIgnore
  private Date updatedAt;
}
