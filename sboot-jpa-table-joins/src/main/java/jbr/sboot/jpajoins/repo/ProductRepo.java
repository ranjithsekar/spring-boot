package jbr.sboot.jpajoins.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jbr.sboot.jpajoins.model.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, Long> {

}
