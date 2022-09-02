package com.alta.bootcamp.stocksapp.websocket.client;

import com.alta.bootcamp.stocksapp.websocket.listener.StompListener;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

public class StompClient {
  public static void main(String[] args) {
    WebSocketClient client = new StandardWebSocketClient();
    WebSocketStompClient stompClient = new WebSocketStompClient(client);

    stompClient.setMessageConverter(new MappingJackson2MessageConverter());

    StompListener stompListener = new StompListener();
    // Listen to binance
    // String URL = "wss://stream-cloud.binanceru.net/ws/btcusdt@aggTrade";
    // Listen to binance 2
    // String URL = "wss://stream-cloud.binanceru.net/ws";
    // Listen to localhost
    String URL = "ws://localhost:8080/ws";
    stompClient.connect(URL, stompListener);

    new Scanner(System.in).nextLine();
  }
}
