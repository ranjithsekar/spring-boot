package jbr.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jbr.swagger.model.Product;
import jbr.swagger.service.ProductService;

@RestController
@Api(value = "Product API Doc", description = "Get Product APIs")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

  @Autowired
  private ProductService productService;

  @ApiOperation("Get all available products")
  @GetMapping("getAllProducts")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @ApiOperation("Get a product by id")
  @ApiResponses(value = { @ApiResponse(code = 1000, message = "SUCCESS"), @ApiResponse(code = 2000, message = "FAIL") })
  @GetMapping("getProductById/{id}")
  public Product getProductById(@PathVariable String id) {
    return productService.getProductById(id);
  }

  @ApiOperation("Add a product")
  @PostMapping("addProduct")
  public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
  }

  @ApiOperation("Update a product detail using id")
  @PutMapping("updateProduct/{id}")
  public void updateProduct(@RequestBody Product product, @PathVariable String id) {
    productService.updateProduct(product, id);
  }

  @ApiOperation("Delete a product using id")
  @DeleteMapping("deleteProduct/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.deleteProduct(id);
  }
}
