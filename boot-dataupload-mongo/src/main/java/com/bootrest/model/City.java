package com.bootrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document(collection = "city")
public class City {
  @Id
  private String name;
  private String countryCode;
  private String stateCode;
  private String latitude;
  private String longitude;
}