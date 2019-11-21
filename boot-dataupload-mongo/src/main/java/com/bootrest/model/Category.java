package com.bootrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for Category.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Data
@Getter
@Setter
@Document(collection = "category")
public class Category {

  /** Category id. **/
  @Id
  private String id;

  /** Category name. **/
  @Indexed(unique = true)
  private String name;

  /** Category title. **/
  private String title;

  /** Category description. **/
  private String description;

  /** Category is active or inactive. **/
  private boolean active;
}