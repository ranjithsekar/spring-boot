package jbr.webshop.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.webshop.product.model.ProductModel;
import jbr.webshop.product.model.ProductResponseModel;
import jbr.webshop.product.resolver.ProductQuery;
import jbr.webshop.product.util.ProductUtil;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductQuery prodQuery;

  @Override
  public List<ProductResponseModel> getAllProducts() {
    List<ProductModel> products = prodQuery.getAllProducts();
    return ProductUtil.getProductResponseModel(products);
  }

}
