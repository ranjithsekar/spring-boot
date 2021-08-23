package jbr.sboot.prod.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.sboot.prod.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

  ProductModel findProductByName(String name);
}
