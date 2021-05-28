package jbr.sboot.restapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.sboot.restapi.dao.ProductRepository;
import jbr.sboot.restapi.model.Product;
import jbr.sboot.restapi.model.ProductDto;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> getAllProducts() {
    log.info("Retrieving all products.");
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(String id) {
    log.info("Retrieving product with id: " + id);
    return productRepository.findById(id).get();
  }

  @Override
  public Product addProduct(ProductDto productDto) {
    log.info("Adding product: " + productDto.toString());
    Product newProduct = new Product(productDto.getId(), productDto.getName(), productDto.getCategory(),
        productDto.getPrice());
    return productRepository.save(newProduct);
  }

  @Override
  public ProductDto updateProduct(ProductDto productDto) {
    log.info("Updating product: " + productDto.toString());
    Product product = getProductById(productDto.getId());
    if (null != product) {
      BeanUtils.copyProperties(productDto, product);
      productRepository.save(product);
    }
    return productDto;
  }

  @Override
  public void deleteProduct(String id) {
    log.info("Deleting produt with id: " + id);
    productRepository.deleteById(id);
  }

}
