package jbr.springboot.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Product Model.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
  private String id;
  private String name;
  private String category;
  private String price;
}
