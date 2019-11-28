package com.bootrest.model;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model for City.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "city")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City extends BaseEntity {
  private static final long serialVersionUID = 1L;

  /** Country code for the city. **/
  private String countryCode;

  /** State code for the city. **/
  private String stateCode;

  /** City code. **/
  private String cityCode;

  /** City name **/
  @TextIndexed
  private String cityName;

  /** Latitude of the city. **/
  private String latitude;

  /** Longitude of the city. **/
  private String longitude;

  /** City is active or inactive. **/
  private boolean active;
}