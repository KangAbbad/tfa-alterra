package com.alta.bootcamp.queueloggingapp.utils;

import com.alta.bootcamp.queueloggingapp.dto.UserRequestDTO;
import com.alta.bootcamp.queueloggingapp.exceptions.ValidationErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ValidateUtils {
  public void userRequest(UserRequestDTO request) {
    if (request == null) {
      throw new ValidationErrorException("Body request cannot be empty");
    }

    if (StringUtils.isEmpty(request.getUsername())) {
      throw new ValidationErrorException("Name cannot be empty");
    }

    if (StringUtils.isEmpty(request.getEmail())) {
      throw new ValidationErrorException("Email cannot be empty");
    }

    if (StringUtils.isEmpty(request.getPassword())) {
      throw new ValidationErrorException("Password cannot be empty");
    }
  }
}
