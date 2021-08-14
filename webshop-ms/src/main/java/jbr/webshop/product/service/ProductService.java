package jbr.webshop.product.service;

import java.util.List;

import jbr.webshop.product.model.ProductResponseModel;

public interface ProductService {
  List<ProductResponseModel> getAllProducts();

}
