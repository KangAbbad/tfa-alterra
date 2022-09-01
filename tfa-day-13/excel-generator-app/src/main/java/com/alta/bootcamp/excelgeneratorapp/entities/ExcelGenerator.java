package com.alta.bootcamp.excelgeneratorapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ExcelGenerator")
@Table(name = "stocks")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class ExcelGenerator {
  @Id
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

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  @JsonProperty("created_at")
  private Date createdAt;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  @JsonProperty("updated_at")
  private Date updatedAt;

  @Override
  public String toString() {
    return "ExcelGenerator{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", ticker='" + ticker + '\'' +
            ", coinId=" + coinId +
            ", code='" + code + '\'' +
            ", exchange='" + exchange + '\'' +
            ", invalid=" + invalid +
            ", recordTime=" + recordTime +
            ", usd=" + usd +
            ", idr=" + idr +
            ", hnst=" + hnst +
            ", eth=" + eth +
            ", btc=" + btc +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
  }
}
