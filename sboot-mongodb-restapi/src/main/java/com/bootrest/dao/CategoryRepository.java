package com.bootrest.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bootrest.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Integer>{

}
