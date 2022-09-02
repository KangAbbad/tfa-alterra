package com.alta.bootcamp.stocksapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StockDTO implements Serializable {
  @JsonProperty("e")
  private String eventType;
  @JsonProperty("E")
  private Long eventTime;
  @JsonProperty("s")
  private String symbol;
  @JsonProperty("a")
  private Long aggregateTradeId;
  @JsonProperty("p")
  private String price;
  @JsonProperty("q")
  private String quantity;
  @JsonProperty("f")
  private Long firstTradeId;
  @JsonProperty("l")
  private Long lastTradeId;
  @JsonProperty("T")
  private Long tradeTime;
  @JsonProperty("m")
  private Boolean isMarketMaker;
  @JsonProperty("M")
  private Boolean isIgnore;

  @Override
  public String toString() {
    return "StockResponseDTO{" +
            "eventType='" + eventType + '\'' +
            ", eventTime=" + eventTime +
            ", symbol='" + symbol + '\'' +
            ", aggregateTradeId=" + aggregateTradeId +
            ", price='" + price + '\'' +
            ", quantity='" + quantity + '\'' +
            ", firstTradeId=" + firstTradeId +
            ", lastTradeId=" + lastTradeId +
            ", tradeTime=" + tradeTime +
            ", isMarketMaker=" + isMarketMaker +
            ", isIgnore=" + isIgnore +
            '}';
  }
}
