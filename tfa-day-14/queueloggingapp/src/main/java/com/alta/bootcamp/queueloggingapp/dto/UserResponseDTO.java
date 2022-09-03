package com.alta.bootcamp.queueloggingapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
  private String email;

  @JsonIgnore
  private String password;
  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  private Date createdAt;
  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  private Date updatedAt;

  @Override
  public String toString() {
    return "{" +
            "\"id\": " + "\"" + id + "\"," +
            "\"username\": " + "\"" + username + "\"," +
            "\"email\": " + "\"" + email + "\"," +
            "\"created_at\": " + "\"" + createdAt + "\"," +
            "\"updated_at\": " + "\"" + updatedAt + "\"," +
            '}';
  }
}
