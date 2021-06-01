package jbr.sboot.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jbr.sboot.graphql.model.Product;
import jbr.sboot.graphql.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductRepository productDao;

  @GetMapping("/greeting")
  public ResponseEntity<Object> greeting() {
    return new ResponseEntity<>("Welcome", HttpStatus.OK);
  }

  @PostMapping("/add")
  public Product addProduct(@RequestBody Product product) {
    return productDao.save(product);
  }

  @GetMapping("/getall")
  public List<Product> getAllProducts() {
    return productDao.findAll();
  }

}
