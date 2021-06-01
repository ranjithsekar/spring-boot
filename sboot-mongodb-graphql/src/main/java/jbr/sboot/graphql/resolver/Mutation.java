package jbr.sboot.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import jbr.sboot.graphql.model.Product;
import jbr.sboot.graphql.repositories.ProductRepository;

@Component
public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private ProductRepository productRepository;

  public Product addProduct(Long id, String name, String category, Long price) {
    Product product = new Product(id, name, category, price);
    return productRepository.save(product);
  }

  public boolean deleteProduct(Long id) {
    productRepository.deleteById(id);
    return true;
  }
}
