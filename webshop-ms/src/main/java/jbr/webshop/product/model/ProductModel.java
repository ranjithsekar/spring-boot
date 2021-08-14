package jbr.webshop.product.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("product")
public class ProductModel {
  private String pid;
  private String scid;
  private String title;
  private String desc;
  private String image;
  private String price;
  private String rating;
}
