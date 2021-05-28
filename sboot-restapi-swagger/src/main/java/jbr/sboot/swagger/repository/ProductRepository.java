package jbr.sboot.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.sboot.swagger.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

  ProductModel findProductByName(String name);
}
