package jbr.sboot.swagger.util;

import jbr.sboot.swagger.dto.ProductDto;
import jbr.sboot.swagger.model.ProductModel;

public class Util {

  public static ProductModel toProductModel(ProductDto productDto) {
    return new ProductModel(productDto.getId(), productDto.getName(), productDto.getCategory(), productDto.getPrice());
  }
}
