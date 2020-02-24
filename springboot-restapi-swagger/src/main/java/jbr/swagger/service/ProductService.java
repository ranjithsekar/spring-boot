package jbr.swagger.service;

import java.util.List;
import java.util.Optional;

import jbr.swagger.model.Product;

public interface ProductService {

  Product addProduct(Product newProduct);

  List<Product> addProducts(List<Product> newProducts);

  List<Product> getAllProducts();

  Optional<Product> getProductById(String id);

  Product updateProduct(Product product);

  void deleteProduct(String id);
}
