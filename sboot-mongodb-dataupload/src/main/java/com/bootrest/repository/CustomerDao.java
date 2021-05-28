package com.bootrest.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootrest.model.Customer;

/**
 * User Mongo Repository.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-28
 */
@Repository
public interface CustomerDao extends MongoRepository<Customer, String> {

  @Query("{'customerId': ?0}")
  Optional<Customer> findByCustomerId(String customerId);
}