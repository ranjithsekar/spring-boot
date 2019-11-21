package com.bootrest.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for SubCategory.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Data
@Getter
@Setter
@Document(collection = "subcategory")
public class SubCategory {

  /** Category Id of this subcategory. **/
  private int categoryId;

  /** Subcategory name. **/
  private String name;

  /** Subcategory title. **/
  private String title;

  /** Subcategory description. **/
  private String desc;

  /** Subcategory is active or inactive. **/
  private boolean active;
}
