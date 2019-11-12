package com.bootrest.model;

import com.bootrest.common.CategoryName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  private int id;
  private CategoryName name;
}
