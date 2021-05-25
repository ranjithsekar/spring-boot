package jbr.swagger.util;

import jbr.swagger.dto.ProductDto;
import jbr.swagger.model.ProductModel;

public class Util {

  public static ProductModel toProductModel(ProductDto productDto) {
    return new ProductModel(productDto.getId(), productDto.getName(), productDto.getCategory(), productDto.getPrice());
  }
}
