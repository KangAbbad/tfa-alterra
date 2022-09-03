package com.alta.bootcamp.laundryapp.controller;

import com.alta.bootcamp.laundryapp.dto.UserRequestDTO;
import com.alta.bootcamp.laundryapp.dto.UserResponseDTO;
import com.alta.bootcamp.laundryapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired
  IUserService userService;

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
    UserResponseDTO response = userService.createUser(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    List<UserResponseDTO> response = userService.getAllUsers();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUser(@PathVariable("id") Long id) {
    UserResponseDTO response = userService.getUser(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO request, @PathVariable("id") Long id) {
    UserResponseDTO response = userService.updateUser(request, id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
    String response = userService.deleteUser(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
