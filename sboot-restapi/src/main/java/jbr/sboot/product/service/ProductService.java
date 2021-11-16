package jbr.sboot.product.service;

import java.util.List;

import jbr.sboot.product.model.ProductDto;
import jbr.sboot.product.model.ProductModel;

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
