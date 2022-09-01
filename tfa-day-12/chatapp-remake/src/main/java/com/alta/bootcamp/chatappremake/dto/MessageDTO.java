package com.alta.bootcamp.chatappremake.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
  public enum MessageTypes {
    JOIN, CHAT, LEAVE
  }
  private String sender;
  private String content;
  private MessageTypes type;
}
