package com.bootrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  private int id;
  private int categoryId;
  private int subcategoryId;
  private int mfgId;
  private int sellerId;
}
