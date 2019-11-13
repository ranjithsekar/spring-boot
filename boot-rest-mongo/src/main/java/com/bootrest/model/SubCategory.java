package com.bootrest.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bootrest.common.SubCategoryName;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document(collection = "subcategory")
public class SubCategory {
  private int categoryId;
  @Indexed(unique = true)
  private SubCategoryName name;
  private String title;
  private String desc;
  private boolean active;
}
