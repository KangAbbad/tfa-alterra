package com.alta.bootcamp.chatappremake.websocket.listener;

import com.alta.bootcamp.chatappremake.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketListener {
  private static final Logger LOG = LoggerFactory.getLogger(WebSocketListener.class);

  @Autowired
  private SimpMessageSendingOperations messagingTemplate;

  @EventListener
  public void handleWebSocketConnectListener(SessionConnectedEvent event) {
    LOG.info("New websocket connection");
    LOG.info(event.toString());
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
    String username = (String) accessor.getSessionAttributes().get("username");

    if (username != null) {
      LOG.info("User disconnected: "+username);

      MessageDTO chatMessage = new MessageDTO();
      chatMessage.setSender(username);
      chatMessage.setType(MessageDTO.MessageTypes.LEAVE);

      messagingTemplate.convertAndSend("/topic/messages", chatMessage);
    }
  }
}
