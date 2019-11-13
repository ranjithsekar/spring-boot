package com.bootrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document(collection = "category")
public class Category {
  @Id
  private int id;
  @Indexed(unique = true)
  private String name;
  private String title;
  private String description;
  private boolean active;
}
