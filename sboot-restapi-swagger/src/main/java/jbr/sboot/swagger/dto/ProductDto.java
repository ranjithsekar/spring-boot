package jbr.sboot.swagger.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Product POJO", description = "Product Value Object")
@Data
public class ProductDto {

  @ApiModelProperty(notes = "Product ID", example = "100", name = "prod id", dataType = "Long")
  // @Size(min = 2, max = 5)
  private Long id;

  @ApiModelProperty(notes = "Product NAME")
  @NotEmpty(message = "name is empty, please provide valid product name.")
  private String name;

  @ApiModelProperty(notes = "Product CATEGORY")
  private String category;

  @ApiModelProperty(notes = "Product PRICE")
  private String price;
}
