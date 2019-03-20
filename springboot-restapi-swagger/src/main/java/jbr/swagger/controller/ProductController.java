package jbr.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jbr.swagger.model.Product;
import jbr.swagger.service.ProductService;

/**
 * Product Controller
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("products/{id}")
	public Product getProductById(@PathVariable String id) {
		return productService.getProductById(id);
	}

	@PostMapping("products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}

	@PutMapping("products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable String id) {
		productService.updateProduct(product, id);
	}

	@DeleteMapping("products/{id}")
	public void deleteProduct(@PathVariable String id) {
		productService.delete(id);
	}
}
