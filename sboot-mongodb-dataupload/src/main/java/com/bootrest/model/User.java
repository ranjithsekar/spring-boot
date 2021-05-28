package com.bootrest.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model for User data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "userType")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
  private static final long serialVersionUID = 1L;

  /** User id. **/
  private String UserId;

  /** User type(ADMIN, CUSTOMER, VENDOR). **/
  private String UserType;

  /** User is active or inactive. **/
  private boolean active;
}
