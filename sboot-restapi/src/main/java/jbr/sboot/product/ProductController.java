package jbr.sboot.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jbr.sboot.product.model.ProductApiResponse;
import jbr.sboot.product.model.ProductDto;
import jbr.sboot.product.model.ProductModel;
import jbr.sboot.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;

/**
 * Product Controller
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(value = "${spring.data.rest.base-path}/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("Hello...");
        return "Hello. Welcome!!!";
    }

    @GetMapping("/all")
    public ProductApiResponse<List<ProductModel>> getAllProducts() {
        return new ProductApiResponse<>(HttpStatus.OK.value(), "All products are retrieved successfully.",
                productService.getAllProducts());
    }

    @PostMapping("/add")
    public ProductApiResponse<ProductModel> addProduct(@RequestBody ProductDto productDto) {
        return new ProductApiResponse<ProductModel>(HttpStatus.OK.value(), "Product added successfully.",
                productService.addProduct(productDto));
    }

    @PutMapping("/update")
    public ProductApiResponse<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return new ProductApiResponse<ProductDto>(HttpStatus.OK.value(), "Product updated successfully.",
                productService.updateProduct(productDto));
    }

    @DeleteMapping("/delete/{id}")
    public ProductApiResponse<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(Long.valueOf(id));
        return new ProductApiResponse<Void>(HttpStatus.OK.value(), "Product deleted successfully.", null);
    }

    @GetMapping("/by-id/{id}")
    public ProductApiResponse<ProductModel> getProductById(@PathVariable Long id) {
        return new ProductApiResponse<ProductModel>(HttpStatus.OK.value(), "Product retrieved successfully.",
                productService.getProductById(id));
    }

}
