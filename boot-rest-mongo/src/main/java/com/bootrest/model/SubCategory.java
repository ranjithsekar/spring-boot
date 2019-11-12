package com.bootrest.model;

import com.bootrest.common.CategoryName;
import com.bootrest.common.SubCategoryName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
  private int categoryId;
  private CategoryName categoryName;
  private SubCategoryName name;
  private String title;
  private String desc;
  private boolean active;
}