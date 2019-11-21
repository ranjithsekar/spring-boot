package com.bootrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for City.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Data
@Getter
@Setter
@Document(collection = "city")
public class City {

  /** City name **/
  @Id
  private String name;

  /** Country code for the city. **/
  private String countryCode;

  /** State code for the city. **/
  private String stateCode;

  /** Latitude of the city. **/
  private String latitude;

  /** Longitude of the city. **/
  private String longitude;

  /** City is active or inactive. **/
  private boolean active;
}