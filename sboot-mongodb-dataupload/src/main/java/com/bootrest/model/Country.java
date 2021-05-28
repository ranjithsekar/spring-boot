package com.bootrest.model;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model for Country.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "country")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Country extends BaseEntity {
  private static final long serialVersionUID = 1L;
  /** Country code. **/
  private String countryCode;

  /** Country name. **/
  @TextIndexed
  private String countryName;

  /** Country is active or inactive. **/
  private boolean active;
}
