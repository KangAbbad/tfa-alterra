package com.alta.bootcamp.queueloggingapp.consumer;

import com.alta.bootcamp.queueloggingapp.dto.UserRequestDTO;
import com.alta.bootcamp.queueloggingapp.entities.User;
import com.alta.bootcamp.queueloggingapp.repositories.UserRepository;
import com.alta.bootcamp.queueloggingapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserConsumer {
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserService userService;

  private static final Logger LOG = LoggerFactory.getLogger(UserConsumer.class);

  @RabbitListener(queues = {"${queue.name}"})
  public void userValidation(@Payload UserRequestDTO request) {
    Optional<User> duplicateEmail = userRepository.findByEmail(request.getEmail());
    Optional<User> duplicateUsername = userRepository.findByUsername(request.getUsername());
    if (duplicateUsername.isPresent() || duplicateEmail.isPresent()) {
      LOG.error("Username / Email already exist!");
    } else {
      userService.createUser(request);
      LOG.info(request.getUsername() + " (" + request.getEmail() + ") " + "terdaftar sebagai user baru");
    }
  }
}
