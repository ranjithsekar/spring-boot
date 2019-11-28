package com.bootrest.model;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model for Category.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "category")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/** Category id. **/
	private String categoryId;

	/** Category name. **/
	@TextIndexed
	private String categoryName;

	/** Category title. **/
	private String categoryTitle;

	/** Category description. **/
	@TextIndexed
	private String description;

	/** Category is active or inactive. **/
	private boolean active;
}