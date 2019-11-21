package com.bootrest.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bootrest.model.State;

@Repository
public interface StateRepository extends MongoRepository<State, String>{

}

