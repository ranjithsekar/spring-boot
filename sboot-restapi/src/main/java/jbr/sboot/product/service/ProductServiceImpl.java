package jbr.sboot.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.util.StringUtils;
import jbr.sboot.product.model.ProductDto;
import jbr.sboot.product.model.ProductModel;
import jbr.sboot.product.repo.ProductRepository;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<ProductModel> getAllProducts() {
    log.info("Retrieving all products.");
    return productRepository.findAll();
  }

  @Override
  public ProductModel getProductById(Long id) {
    log.info("Retrieving product with id: " + id);
    return productRepository.findById(id)
        .get();
  }

  @Override
  public ProductModel addProduct(ProductDto productDto) {
    log.info("Adding product: " + productDto.toString());
    ProductModel newProduct = new ProductModel(productDto.getId(), productDto.getName(), productDto.getCategory(),
        productDto.getPrice(), null, null);
    return productRepository.save(newProduct);
  }

  @Override
  public ProductDto updateProduct(ProductDto productDto) {
    log.info("Updating product: " + productDto.toString());
    ProductModel product = getProductById(productDto.getId());
    if (null != product) {
      // BeanUtils.copyProperties(productDto, product);
      if (StringUtils.isNotEmpty(productDto.getName())) product.setName(productDto.getName());
      if (StringUtils.isNotEmpty(productDto.getCategory())) product.setCategory(productDto.getCategory());
      if (null != productDto.getPrice()) product.setPrice(productDto.getPrice());

      productRepository.save(product);
    }
    return productDto;
  }

  @Override
  public void deleteProduct(Long id) {
    log.info("Deleting produt with id: " + id);
    productRepository.deleteById(id);
  }

}
