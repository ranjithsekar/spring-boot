package com.bootrest.model;

import java.io.Serializable;
import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Document
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

  @Id
  private ObjectId id;

  @CreatedBy
  private String user;

  @CreatedDate
  private Instant createdDate;

  @LastModifiedBy
  private String lastModifiedUser;

  @LastModifiedDate
  private Instant lastModifiedDate;

}