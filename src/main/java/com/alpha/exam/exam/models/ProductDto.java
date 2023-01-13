package com.alpha.exam.exam.models;

import com.alpha.exam.exam.serializers.DecimalJsonSerializer;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
public class ProductDto {

  private UUID id;
  private String price;
  private String continent;
  private String multiplier;
  private String createdAt;
  
  @JsonSerialize(using = DecimalJsonSerializer.class)
  private double multipliedValue;
}
