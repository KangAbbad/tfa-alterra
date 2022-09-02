package com.alta.bootcamp.stocksapp.websocket.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketListener {
  private static final Logger LOG = LoggerFactory.getLogger(WebSocketListener.class);

  @EventListener
  public void handleWebSocketConnectListener(SessionConnectedEvent event) {
    LOG.info("New Connection: " + event.toString());
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    LOG.info("Disconnected");
  }
}
