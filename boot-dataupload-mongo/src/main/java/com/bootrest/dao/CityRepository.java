package com.bootrest.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bootrest.model.City;

@Repository
public interface CityRepository extends MongoRepository<City, String>{

}