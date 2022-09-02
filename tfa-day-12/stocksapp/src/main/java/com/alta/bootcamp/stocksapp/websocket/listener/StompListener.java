package com.alta.bootcamp.stocksapp.websocket.listener;

import com.alta.bootcamp.stocksapp.dto.StockDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class StompListener extends StompSessionHandlerAdapter {
  private static final Logger logger = LoggerFactory.getLogger(WebSocketListener.class);

  @Override
  public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
    logger.info("--- LOGGER STARTED ---");
    logger.info("New session established: " + session.getSessionId());
    session.subscribe("/topic/messages", this);
  }

  @Override
  public Type getPayloadType(StompHeaders headers) {
    return StockDTO.class;
  }

  @Override
  public void handleFrame(StompHeaders headers, Object payload) {
     StockDTO request = (StockDTO) payload;
     logger.info(request.toString());
  }

  @Override
  public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
    logger.error("Got an exception", exception);
  }
}
