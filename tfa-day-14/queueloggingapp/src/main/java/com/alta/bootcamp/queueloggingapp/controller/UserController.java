package com.alta.bootcamp.queueloggingapp.controller;

import com.alta.bootcamp.queueloggingapp.dto.UserRequestDTO;
import com.alta.bootcamp.queueloggingapp.dto.UserResponseDTO;
import com.alta.bootcamp.queueloggingapp.services.IPublisherService;
import com.alta.bootcamp.queueloggingapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired
  IUserService userService;

  @Autowired
  IPublisherService publisherService;

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
    UserResponseDTO response = userService.createUser(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PostMapping("/with-rabbit")
  public ResponseEntity<String> createUserWithRabbit(@RequestBody UserRequestDTO request) {
    publisherService.send(request);
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
      .body("Your account registration is being processed!");
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
