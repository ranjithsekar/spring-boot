package jbr.graphql.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import jbr.graphql.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
