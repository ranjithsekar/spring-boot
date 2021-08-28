package jbr.webshop.product.model;

import java.util.List;

import jbr.webshop.common.model.ApiResponseEntity;
import lombok.Data;

@Data
public class ProductResponse implements ApiResponseEntity {
  private static final long serialVersionUID = 1L;

  private List<ProductResponseModel> products;

  public ProductResponse() {
  }

  public ProductResponse(List<ProductResponseModel> products) {
    this.products = products;
  }

}
