package com.alpha.exam.exam.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Product {
  
  @Id
  @Type(type = "uuid-char")
  @Column(name = "id", nullable = false)
  private UUID id = UUID.randomUUID();

  @Column(length = 20)
  private String price;

  @Column(length = 10)
  private String continent;

  @Column(length = 10)
  private String multiplier;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

}
