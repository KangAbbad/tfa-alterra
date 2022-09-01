package com.alta.bootcamp.excelgeneratorapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ExcelGeneratorDTO {
  private Long id;
  private String name;
  private String ticker;

  @JsonProperty("coin_id")
  private Long coinId;

  private String code;
  private String exchange;
  private int invalid;

  @JsonProperty("record_time")
  private Long recordTime;

  private Long usd;
  private Long idr;
  private int hnst;
  private Long eth;
  private Long btc;

  @JsonProperty("created_at")
  private Date createdAt;

  @JsonProperty("updated_at")
  private Date updatedAt;
}
