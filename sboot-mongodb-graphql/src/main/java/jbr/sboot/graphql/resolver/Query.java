package jbr.sboot.graphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import jbr.sboot.graphql.model.Product;
import jbr.sboot.graphql.repositories.ProductRepository;

@Component
public class Query implements GraphQLQueryResolver {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(Long id) {
    return productRepository.findById(id)
        .get();
  }
}