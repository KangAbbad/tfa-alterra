package com.alta.bootcamp.queueloggingapp.services;

import com.alta.bootcamp.queueloggingapp.dto.UserRequestDTO;

import java.io.Serializable;

public interface IPublisherService extends Serializable {
  void send(UserRequestDTO request);
}
