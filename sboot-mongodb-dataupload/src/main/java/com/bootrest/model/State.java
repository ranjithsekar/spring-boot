package com.bootrest.model;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model for State.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "state")
@Getter
@Setter
@NoArgsConstructor
public class State extends BaseEntity {
  private static final long serialVersionUID = 1L;

  /** State code. **/
  private String stateCode;

  /** State name. **/
  @TextIndexed
  private String stateName;

  /** Country code of the state. **/
  private String countryCode;

  /** State is active or inactive. **/
  private boolean active;
}