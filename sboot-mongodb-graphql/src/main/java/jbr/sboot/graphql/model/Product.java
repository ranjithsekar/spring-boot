package jbr.sboot.graphql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@Document(collection = "product")
public class Product {

  @Id
  private Long id;
  private String name;
  private String category;
  private Long price;
}
