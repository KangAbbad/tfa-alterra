package com.alta.bootcamp.authapp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class JwtAuthenticationResponseData {
  private final String accessToken;
  private String tokenType = "Bearer";
}
