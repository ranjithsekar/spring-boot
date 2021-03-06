package jbr.sboot.swagger.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jbr.sboot.swagger.dto.ProductDto;
import jbr.sboot.swagger.exception.ProductExistsException;
import jbr.sboot.swagger.exception.ProductNameNotFoundException;
import jbr.sboot.swagger.exception.ProductNotFoundException;
import jbr.sboot.swagger.model.ProductModel;
import jbr.sboot.swagger.service.ProductServiceImpl;
import jbr.sboot.swagger.util.Util;

@RestController
@Api(value = "Product API Doc", description = "Get Product APIs")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductServiceImpl productService;

  @GetMapping("/hello")
  public String hello() {
    return "Hello. Welcome!!!";
  }

  @ApiOperation("Get all available products")
  @GetMapping("/all")
  public List<ProductModel> getAllProducts() {
    return productService.getAllProducts();
  }

  @ApiOperation("Get a product by id")
  @ApiResponses(value = { @ApiResponse(code = 1000, message = "SUCCESS"), @ApiResponse(code = 2000, message = "FAIL") })
  @GetMapping("/by-id/{id}")
  public Optional<ProductModel> getProductById(@Valid @PathVariable @Min(1) String id) {
    try {
      return productService.getProductById(id);
    } catch (ProductNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @ApiOperation("Get a product by name")
  @ApiResponses(value = { @ApiResponse(code = 1000, message = "SUCCESS"), @ApiResponse(code = 2000, message = "FAIL") })
  @GetMapping("/by-name/{name}")
  public ProductModel getProductByName(@PathVariable("name") String name) throws ProductNameNotFoundException {
    ProductModel product = productService.getProductByName(name);

    if (null == product)
      throw new ProductNameNotFoundException("Product name: '" + name + "' Not found in the product repository");

    return product;
  }

  @ApiOperation("Add a product")
  @PostMapping("/add-product")
  public ResponseEntity<Void> addProduct(@Valid @RequestBody ProductDto productDto, UriComponentsBuilder builder) {

    try {
      productService.addProduct(Util.toProductModel(productDto));
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(builder.path("/addProduct")
          .buildAndExpand(productDto.getId())
          .toUri());
      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    } catch (ProductExistsException ex) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
  }

  @ApiOperation("Add multiple products")
  @PostMapping("/add-products")
  public List<ProductModel> addProducts(@RequestBody ProductDto[] products) {
    List<ProductModel> productList = Stream.of(products)
        .map(e -> Util.toProductModel(e))
        .collect(Collectors.toList());
    return productService.addProducts(productList);
  }

  @ApiOperation("Update a product detail using id")
  @PutMapping("/update-product/{id}")
  public void updateProduct(@RequestBody ProductModel product, @PathVariable String id) {
    try {
      productService.updateProduct(id, product);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @ApiOperation("Delete a product using id")
  @DeleteMapping("/delete-product/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.deleteProduct(id);
  }

  @ApiOperation("Get a product by price range")
  @GetMapping("/by-price-range/{minPrice}/{maxPrice}")
  public List<ProductModel> getProductByPriceRange(@PathVariable String minPrice, @PathVariable String maxPrice) {
    return productService.getProductsByPriceMinMax(minPrice, maxPrice);
  }

  @ApiOperation("Get a product by minimum price")
  @GetMapping("/by-min-price/{minPrice}")
  public List<ProductModel> getProductByMinPrice(@PathVariable String minPrice) {
    return productService.getProductsByPriceMin(minPrice);
  }

  @ApiOperation("Get a product by maximum price")
  @GetMapping("/by-max-price/{maxPrice}")
  public List<ProductModel> getProductByMaxPrice(@PathVariable String maxPrice) {
    return productService.getProductsByPriceMax(maxPrice);
  }

}
