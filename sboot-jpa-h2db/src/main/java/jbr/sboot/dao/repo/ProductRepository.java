package jbr.sboot.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.sboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

  //List<Product> getCustomProd(String prodName);
}
