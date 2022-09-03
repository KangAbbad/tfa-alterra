package com.alta.bootcamp.queueloggingapp.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserPublisher {
  @Value("${queue.name}")
  private String queueName;

  @Bean
  public Queue queue() {
    return new Queue(queueName, true);
  }
}
