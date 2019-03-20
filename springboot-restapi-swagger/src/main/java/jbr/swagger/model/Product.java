package jbr.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Product Model.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@ApiModel(value = "Product POJO", description = "Product Value Object")
public class Product {

  @ApiModelProperty(notes = "Product ID", example = "100", name = "prod id", dataType = "String")
  private String id;

  @ApiModelProperty(notes = "Product NAME")
  private String name;

  @ApiModelProperty(notes = "Product TYPE")
  private String type;

  @ApiModelProperty(notes = "Product PRICE")
  private String price;

  public Product() {
  }

  public Product(String id, String name, String type, String price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "id:" + this.id + " | name: " + this.name + " | type: " + this.type + " | price: " + this.price;
  }

}
