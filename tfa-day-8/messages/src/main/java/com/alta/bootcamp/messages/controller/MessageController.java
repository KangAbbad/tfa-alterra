package com.alta.bootcamp.messages.controller;

import com.alta.bootcamp.messages.request.MessageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
  @GetMapping("/")
  public String indexHomepage() {
    return "Welcome to Homepage!";
  }

  @GetMapping("/v1/messages")
  public String indexMessages() {
    return "Hello World";
  }

  @PostMapping("/v1/messages")
  public String saveMessages(@RequestBody MessageRequest request) {
    if (request == null) {
      return "Hello World";
    }

    return "message: " + request.getMessage();
  }

//  @DeleteMapping("/v1/messages/{id}")
//  public String deleteMessage(@PathVariable int id) {
//    if (id > -1) {
//      return "Deleted ID: " + id;
//    }
//
//    return "Hello World";
//  }

  @DeleteMapping("/v1/messages")
  public String deleteMessage() {
    return "Hello World";
  }
}
