package com.alta.bootcamp.chatappremake.websocket.listener;

import com.alta.bootcamp.chatappremake.dto.MessageDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class StompListener extends StompSessionHandlerAdapter {
  private final Logger logger = LogManager.getLogger(StompListener.class);

  @Override
  public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
    logger.info("--- LOGGER STARTED ---");
    logger.info("New session established: " + session.getSessionId());
    session.subscribe("/topic/messages", this);
    logger.info("Subscribed to /topic/messages");
    logger.info("Message sent to websocket server");
  }

  @Override
  public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
    logger.error("Got an exception", exception);
  }

  @Override
  public Type getPayloadType(StompHeaders headers) {
    return MessageDTO.class;
  }

  @Override
  public void handleFrame(StompHeaders headers, Object payload) {
    MessageDTO request = (MessageDTO) payload;
    logger.info("Sender: " + request.getSender());
    logger.info("Type: " + request.getType());
    logger.info("Content: " + request.getContent());
  }
}
