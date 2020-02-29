package jbr.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jbr.mongodb.dao.ProductRepository;
import jbr.mongodb.model.Product;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootMongodbEmbeddedApplication implements CommandLineRunner {

  @Autowired
  private ProductRepository productRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMongodbEmbeddedApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    productRepository.save(new Product("100", "Samsung J8 Plus", "Phone", "20000"));
    productRepository.findAll().forEach(e -> log.info(e.toString()));
  }
}
