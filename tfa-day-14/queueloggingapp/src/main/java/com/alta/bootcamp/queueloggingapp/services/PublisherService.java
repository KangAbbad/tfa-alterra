package com.alta.bootcamp.queueloggingapp.services;

import com.alta.bootcamp.queueloggingapp.dto.UserRequestDTO;
import com.alta.bootcamp.queueloggingapp.utils.ValidateUtils;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService implements IPublisherService {
  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private Queue queue;

  @Autowired
  ValidateUtils validateUtils;

  @Override
  public void send(UserRequestDTO request) {
    validateUtils.userRequest(request);
    rabbitTemplate.convertAndSend(queue.getName(), request);
  }
}
