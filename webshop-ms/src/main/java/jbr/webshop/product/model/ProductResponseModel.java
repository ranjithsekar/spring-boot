package jbr.webshop.product.model;

import jbr.webshop.common.model.ApiResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseModel implements ApiResponseEntity {
  private static final long serialVersionUID = 1L;
  private String category;
  private String subcategory;
  private String title;
  private String desc;
  private String price;
  private String rating;
}
