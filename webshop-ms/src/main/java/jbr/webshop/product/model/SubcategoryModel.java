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
@Document("subcategory")
public class SubcategoryModel {
  private String scid;
  private String name;
  private String cid;
}
