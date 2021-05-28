package jbr.sboot.swagger.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.sboot.swagger.dao.ProductDao;
import jbr.sboot.swagger.exception.ProductExistsException;
import jbr.sboot.swagger.exception.ProductNotFoundException;
import jbr.sboot.swagger.model.ProductModel;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductDao productDao;

  @Override
  public ProductModel addProduct(ProductModel newProduct) throws ProductExistsException {
    log.info("addProduct: id " + newProduct.getId());
    return productDao.addProduct(newProduct);
  }

  @Override
  public List<ProductModel> addProducts(List<ProductModel> newProducts) {
    log.info("addProducts: ids: " + newProducts.stream()
        .map(e -> String.valueOf(e.getId()))
        .collect(Collectors.joining(",")));
    return productDao.addProducts(newProducts);
  }

  @Override
  public List<ProductModel> getAllProducts() {
    log.info("getAllProducts");
    return productDao.getAllProducts();
  }

  @Override
  public Optional<ProductModel> getProductById(String id) throws ProductNotFoundException {
    log.info("getProductById: " + id);
    return productDao.getProductById(id);
  }

  @Override
  public ProductModel updateProduct(String id, ProductModel product) throws ProductNotFoundException {
    return productDao.updateProduct(id, product);
  }

  @Override
  public void deleteProduct(String id) {
    log.info("deleteProduct: id" + id);
    productDao.deleteProduct(id);
  }

  @Override
  public ProductModel getProductByName(String name) {
    log.info("deleteProduct: name" + name);
    return productDao.getProductByName(name);
  }
}
