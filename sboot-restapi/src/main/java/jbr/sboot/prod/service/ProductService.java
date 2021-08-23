package jbr.sboot.prod.service;

import java.util.List;

import jbr.sboot.prod.model.ProductModel;
import jbr.sboot.prod.model.ProductDto;

/**
 * Product Service.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
public interface ProductService {
  List<ProductModel> getAllProducts();

  ProductModel getProductById(Long id);

  ProductModel addProduct(ProductDto productDto);

  ProductDto updateProduct(ProductDto productDto);

  void deleteProduct(Long id);
}
