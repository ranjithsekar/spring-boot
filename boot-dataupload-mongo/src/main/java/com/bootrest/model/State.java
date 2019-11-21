package com.bootrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for State.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Data
@Getter
@Setter
@Document(collection = "state")
public class State {

  /** State name. **/
  @Id
  private String name;

  /** State code. **/
  private String code;

  /** Country code of the state. **/
  private String countryCode;
}