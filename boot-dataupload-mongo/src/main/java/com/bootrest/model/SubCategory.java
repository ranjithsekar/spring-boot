package com.bootrest.model;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model for SubCategory.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "subCategory")
@Getter
@Setter
@NoArgsConstructor
public class SubCategory extends BaseEntity {

  private static final long serialVersionUID = 1L;

  /** Category Id of this subcategory. **/
  @TextIndexed
  private String categoryId;

  /** Sub category id. **/
  private String subCategoryId;

  /** Subcategory name. **/
  @TextIndexed
  private String subCategoryName;

  /** Subcategory title. **/
  private String subCategoryTitle;

  /** Subcategory description. **/
  @TextIndexed
  private String description;

  /** Subcategory is active or inactive. **/
  private boolean active;
}
