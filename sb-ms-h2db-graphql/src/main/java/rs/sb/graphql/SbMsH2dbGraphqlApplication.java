package rs.sb.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rs.sb.graphql.dao.ProductRepository;
import rs.sb.graphql.model.Product;

@SpringBootApplication
public class SbMsH2dbGraphqlApplication implements CommandLineRunner {

  @Autowired
  private ProductRepository productRepository;

  public static void main(String[] args) {
    SpringApplication.run(SbMsH2dbGraphqlApplication.class, args);
  }
  
  @Override
  public void run(String... args) throws Exception {
    productRepository.save(new Product(100L, "Samsung S10", "Mobile", 9000L));
  }

}
