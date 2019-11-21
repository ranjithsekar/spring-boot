package com.bootrest.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bootrest.model.Country;

@Repository
public interface CountryRepository extends MongoRepository<Country, String>{

}