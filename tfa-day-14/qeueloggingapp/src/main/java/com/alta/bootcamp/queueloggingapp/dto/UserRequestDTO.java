package com.alta.bootcamp.queueloggingapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserRequestDTO implements Serializable {
  private String username;
  private String email;
  private String password;

  @Override
  public String toString() {
    return "{" +
            "\"username\":" + "\"" + username + "\"," +
            "\"email\":" + "\"" + email + "\"," +
            "\"password\":" + "\"" + password + "\"" +
            "}";
  }
}
