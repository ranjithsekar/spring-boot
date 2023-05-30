package jbr.sboot.restapi.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.sboot.restapi.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

  ProductModel findProductByName(String name);
}
