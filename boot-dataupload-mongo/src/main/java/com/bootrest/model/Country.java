package com.bootrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for Country.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Data
@Getter
@Setter
@Document(collection = "country")
public class Country {

  /** Country name. **/
  @Id
  private String name;

  /** Country code. **/
  private String code;
}
