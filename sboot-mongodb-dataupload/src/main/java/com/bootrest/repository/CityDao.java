package com.bootrest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bootrest.model.City;

/**
 * City Mongo Repository.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Repository
public interface CityDao extends MongoRepository<City, String> {

}