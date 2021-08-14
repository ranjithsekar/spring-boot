package jbr.webshop.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import jbr.webshop.product.model.ProductModel;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, Long> {

}
