package jbr.webshop.product.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import jbr.webshop.product.model.ProductModel;
import jbr.webshop.product.repository.ProductRepository;

/**
 * Query - to select (retrieve)
 *
 */
@Component
public class ProductQuery implements GraphQLQueryResolver {
  @Autowired
  private ProductRepository productRepository;

  public List<ProductModel> getAllProducts() {
    return productRepository.findAll();
  }

}