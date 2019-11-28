package com.bootrest.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "customer")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer extends BaseEntity {
  private static final long serialVersionUID = 1L;

  private String customerId;
  private String customerName;
  private List<String> favoriteCategories;

}
