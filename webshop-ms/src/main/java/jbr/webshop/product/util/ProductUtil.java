package jbr.webshop.product.util;

import java.util.ArrayList;
import java.util.List;

import jbr.webshop.product.model.ProductModel;
import jbr.webshop.product.model.ProductResponseModel;

public class ProductUtil {

  public static List<ProductResponseModel> getProductResponseModel(List<ProductModel> products) {
    List<ProductResponseModel> prodRespose = new ArrayList<>();

    products.forEach(e ->
      {
        prodRespose.add(new ProductResponseModel("", "", e.getTitle(), e.getDesc(), e.getPrice(), e.getRating()));
      });

    return prodRespose;
  }
}
