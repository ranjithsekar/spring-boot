package jbr.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import jbr.graphql.model.Product;
import jbr.graphql.repositories.ProductRepository;

@Component
public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private ProductRepository productRepository;

  public Product addProduct(String id, String name, String type, String price) {
    Product product = new Product(id, name, type, price);
    return productRepository.save(product);
  }

  public boolean deleteProduct(String id) {
    productRepository.deleteById(id);
    return true;
  }
}
