package com.alta.bootcamp.stocksapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StockRequestDTO implements Serializable {
  private String sender;
}
