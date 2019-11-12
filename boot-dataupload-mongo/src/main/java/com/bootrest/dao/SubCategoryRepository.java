package com.bootrest.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bootrest.model.SubCategory;

@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {

}
