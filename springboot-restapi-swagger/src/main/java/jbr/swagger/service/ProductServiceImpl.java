package jbr.swagger.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.swagger.model.Product;
import jbr.swagger.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Product addProduct(Product newProduct) {
    log.info("addProduct: " + newProduct.getId());
    return productRepository.save(newProduct);
  }

  @Override
  public List<Product> addProducts(List<Product> newProducts) {
    log.info("addProducts: " + newProducts.stream()
        .map(e -> e.getId())
        .collect(Collectors.joining(",")));

    return productRepository.saveAll(newProducts);
  }

  @Override
  public List<Product> getAllProducts() {
    log.info("getAllProducts");
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> getProductById(String id) {
    log.info("getProductById: " + id);
    return productRepository.findById(id);
  }

  @Override
  public Product updateProduct(Product product) {
    log.info("addProduct: " + product.getId());
    return productRepository.save(product);
  }

  @Override
  public void deleteProduct(String id) {
    log.info("deleteProduct: " + id);
    productRepository.deleteById(id);
  }
}
