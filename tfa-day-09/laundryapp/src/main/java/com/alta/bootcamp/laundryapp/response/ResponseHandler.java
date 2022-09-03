package com.alta.bootcamp.laundryapp.response;

import com.alta.bootcamp.laundryapp.dto.UserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {
  public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, List<UserResponseDTO> responseObj) {
    Map<String, Object> map = new HashMap<>();
    map.put("message", message);
    map.put("status", status);
    map.put("data", responseObj);

    return new ResponseEntity<>(map, status);
  }
}
