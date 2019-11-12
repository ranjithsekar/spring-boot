package com.bootrest.model;

import com.bootrest.common.SubCategoryName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
  private int id;
  private SubCategoryName name;
}
