package rs.sb.graphql.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import rs.sb.graphql.dao.ProductRepository;
import rs.sb.graphql.model.Product;

public class Query implements GraphQLQueryResolver {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAllProducts() {
    List<Product> products = new ArrayList<>();
    productRepository.findAll()
        .forEach(e ->
          {
            Product prod = new Product();
            prod.setId(e.getId());
            prod.setName(e.getName());
            prod.setCategory(e.getCategory());
            prod.setPrice(e.getPrice());

            products.add(prod);
          });
    return products;
  }

  public Product findProductById(Long id) {
    return productRepository.findById(id)
        .get();
  }

}
