package com.alta.bootcamp.authapp.controller;

import com.alta.bootcamp.authapp.annotations.CurrentUser;
import com.alta.bootcamp.authapp.dto.*;
import com.alta.bootcamp.authapp.entities.Role;
import com.alta.bootcamp.authapp.entities.RolesEnum;
import com.alta.bootcamp.authapp.entities.User;
import com.alta.bootcamp.authapp.exceptions.ValidationErrorException;
import com.alta.bootcamp.authapp.repositories.RoleRepository;
import com.alta.bootcamp.authapp.repositories.UserRepository;
import com.alta.bootcamp.authapp.securities.config.JwtTokenProvider;
import com.alta.bootcamp.authapp.services.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleRepository roleRepository;
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        loginRequest.getUsernameOrPhone(),
        loginRequest.getPassword()
      )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = jwtTokenProvider.generateToken(authentication);
    JwtAuthenticationResponse response = new JwtAuthenticationResponse();
    JwtAuthenticationResponseData responseData = new JwtAuthenticationResponseData(jwt);
    response.setData(responseData);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDTO request) {
    if(userRepository.existsByUsername(request.getUsername())) {
      return new ResponseEntity<>(new ApiResponse(false, "Username is already taken!"),
              HttpStatus.BAD_REQUEST);
    }

    if(userRepository.existsByPhone(request.getPhone())) {
      return new ResponseEntity<>(
        new ApiResponse(false, "Phone Address already in use!"),
        HttpStatus.BAD_REQUEST
      );
    }

    // Creating user's account
    User user = new User();
    user.setUsername(request.getUsername());
    user.setPhone(request.getPhone());
    user.setPassword(request.getPassword());

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    Role userRole = roleRepository.findByName(RolesEnum.USER)
            .orElseThrow(() -> new ValidationErrorException("User Role not set."));

    user.setRoles(Collections.singleton(userRole));

    User result = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
            .fromCurrentContextPath().path("/api/users/{username}")
            .buildAndExpand(result.getUsername()).toUri();

    return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
  }

  @GetMapping("/info")
  public UserJwtResponseDTO getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    UserJwtResponseDTO user = new UserJwtResponseDTO();
    UserJwtResponseData userData = new UserJwtResponseData();
    userData.setPhone(currentUser.getPhone());
    user.setData(userData);
    return user;
  }
}
