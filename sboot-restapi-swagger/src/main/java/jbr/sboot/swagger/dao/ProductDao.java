package jbr.sboot.swagger.dao;

import java.util.List;
import java.util.Optional;

import jbr.sboot.swagger.exception.ProductExistsException;
import jbr.sboot.swagger.exception.ProductNotFoundException;
import jbr.sboot.swagger.model.ProductModel;

public interface ProductDao {

  ProductModel addProduct(ProductModel newProduct) throws ProductExistsException;

  List<ProductModel> addProducts(List<ProductModel> newProducts);

  List<ProductModel> getAllProducts();

  Optional<ProductModel> getProductById(String id) throws ProductNotFoundException;

  ProductModel getProductByName(String name);

  ProductModel updateProduct(String id, ProductModel product) throws ProductNotFoundException;

  void deleteProduct(String id);
  
  List<ProductModel> getProductsByPriceMinMax(String minPrice, String maxPrice);

  List<ProductModel> getProductsByPriceMin(String minPrice);

  List<ProductModel> getProductsByPriceMax(String minPrice);
}
