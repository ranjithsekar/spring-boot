package jbr.webshop.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseModel {
  private String category;
  private String subcategory;
  private String title;
  private String desc;
  private String price;
  private String rating;
}
