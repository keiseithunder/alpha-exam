package com.alpha.exam.exam.models;

import lombok.Data;

@Data
public class CreateProductDto {
  private double price;
  private String continent;
  private int multiplier;
}
