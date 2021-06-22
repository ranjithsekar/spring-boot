package jbr.sboot.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jbr.sboot.swagger.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

  ProductModel findProductByName(String name);

  @Query(value = "SELECT * FROM Product WHERE price BETWEEN ?1 AND ?2")
  List<ProductModel> getProductsByPriceMinMax(String minPrice, String maxPrice);

  @Query(value = "SELECT * FROM Product WHERE price >= ?1")
  List<ProductModel> getProductsByPriceMin(String minPrice);

  @Query(value = "SELECT * FROM Product WHERE price <= ?1")
  List<ProductModel> getProductsByPriceMax(String maxPrice);
}
