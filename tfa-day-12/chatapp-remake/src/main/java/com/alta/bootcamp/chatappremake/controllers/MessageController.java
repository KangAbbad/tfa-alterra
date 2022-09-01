package com.alta.bootcamp.chatappremake.controllers;

import com.alta.bootcamp.chatappremake.dto.MessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
  @MessageMapping("/chat/sendMessage")
  @SendTo("/topic/messages")
  public MessageDTO sendMessage(@Payload MessageDTO message) {
    return message;
  }

  @MessageMapping("/chat/addUser")
  @SendTo("/topic/messages")
  public MessageDTO addUser(@Payload MessageDTO chatMessage, SimpMessageHeaderAccessor accessor) {
    accessor.getSessionAttributes().put("username", chatMessage.getSender());
    return chatMessage;
  }
}
