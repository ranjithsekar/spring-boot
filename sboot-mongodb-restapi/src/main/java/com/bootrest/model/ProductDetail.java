package com.bootrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

  private int id;
  private String name;
  private double price;
  private double discountPercent;
  private String modelNo;
  private String modelName;
  private String image;
}
