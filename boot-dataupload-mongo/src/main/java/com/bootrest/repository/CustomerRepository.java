package com.bootrest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bootrest.model.Customer;
/**
 * User Mongo Repository.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-28
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}