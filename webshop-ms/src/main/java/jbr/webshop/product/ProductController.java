package jbr.webshop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jbr.webshop.common.model.ApiResponseEnvelope;
import jbr.webshop.product.model.ProductResponse;
import jbr.webshop.product.model.ProductResponseModel;
import jbr.webshop.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductController {

  @Autowired
  private ProductService productService;

  @RequestMapping(value = "${spring.data.rest.base-path}/product/all", method = RequestMethod.GET)
  public ResponseEntity<ApiResponseEnvelope> getAllProducts() {

    try {
      List<ProductResponseModel> products = productService.getAllProducts();
      return new ResponseEntity<>(new ApiResponseEnvelope(HttpStatus.OK.value(), new ProductResponse(products)),
          HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error during user validate: " + e);
      return new ResponseEntity<>(new ApiResponseEnvelope(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
}
