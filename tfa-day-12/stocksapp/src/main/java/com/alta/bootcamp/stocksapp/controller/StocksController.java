package com.alta.bootcamp.stocksapp.controller;

import com.alta.bootcamp.stocksapp.dto.StockDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StocksController {
  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public StockDTO addUser(@Payload StockDTO chatMessage) { return chatMessage; }
}
