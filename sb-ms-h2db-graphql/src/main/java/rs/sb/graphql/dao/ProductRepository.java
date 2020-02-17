package rs.sb.graphql.dao;

import org.springframework.data.repository.CrudRepository;

import rs.sb.graphql.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
