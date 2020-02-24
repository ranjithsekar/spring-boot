package jbr.swagger.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "Product POJO", description = "Product Value Object")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {

  @ApiModelProperty(notes = "Product ID", example = "100", name = "prod id", dataType = "String")
  @Id
  private String id;

  @ApiModelProperty(notes = "Product NAME")
  private String name;

  @ApiModelProperty(notes = "Product CATEGORY")
  private String category;

  @ApiModelProperty(notes = "Product PRICE")
  private String price;
}
