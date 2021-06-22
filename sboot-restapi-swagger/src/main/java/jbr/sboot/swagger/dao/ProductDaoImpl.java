package jbr.sboot.swagger.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jbr.sboot.swagger.exception.ProductExistsException;
import jbr.sboot.swagger.exception.ProductNotFoundException;
import jbr.sboot.swagger.model.ProductModel;
import jbr.sboot.swagger.repository.ProductRepository;

@Component
public class ProductDaoImpl implements ProductDao {

  @Autowired
  ProductRepository productRepo;

  @Override
  public ProductModel addProduct(ProductModel newProduct) throws ProductExistsException {
    Optional<ProductModel> product = productRepo.findById(newProduct.getId());

    if (product.isPresent()) {
      throw new ProductExistsException("Product already found!!");
    }

    return productRepo.save(newProduct);
  }

  @Override
  public List<ProductModel> addProducts(List<ProductModel> newProducts) {
    return productRepo.saveAll(newProducts);
  }

  @Override
  public List<ProductModel> getAllProducts() {
    return productRepo.findAll();
  }

  @Override
  public Optional<ProductModel> getProductById(String id) throws ProductNotFoundException {
    Optional<ProductModel> product = productRepo.findById(Long.valueOf(id));

    if (!product.isPresent()) {
      throw new ProductNotFoundException("Product not found in the repository!!");
    }

    return productRepo.findById(Long.valueOf(id));
  }

  @Override
  public ProductModel getProductByName(String name) {
    return productRepo.findProductByName(name);
  }

  @Override
  public ProductModel updateProduct(String id, ProductModel product) throws ProductNotFoundException {
    Optional<ProductModel> prod = productRepo.findById(Long.valueOf(id));

    if (!prod.isPresent()) {
      throw new ProductNotFoundException("Product not found in the repository to update!!");
    }

    return productRepo.save(product);
  }

  @Override
  public void deleteProduct(String id) {
    productRepo.deleteById(Long.valueOf(id));
  }

  @Override
  public List<ProductModel> getProductsByPriceMinMax(String minPrice, String maxPrice) {
    return productRepo.getProductsByPriceMinMax(minPrice, maxPrice);
  }

  @Override
  public List<ProductModel> getProductsByPriceMin(String minPrice) {
    return productRepo.getProductsByPriceMin(minPrice);
  }

  @Override
  public List<ProductModel> getProductsByPriceMax(String maxPrice) {
    return productRepo.getProductsByPriceMax(maxPrice);
  }

}
