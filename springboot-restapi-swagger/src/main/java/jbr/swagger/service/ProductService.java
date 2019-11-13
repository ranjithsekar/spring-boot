package jbr.swagger.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import jbr.swagger.model.Product;

@Service
public class ProductService {

  List<Product> products = Stream
      .of(new Product("100", "Galaxy S8", "Mobile", "50000"), new Product("200", "Honda Shine", "Vehicle", "60000"),
          new Product("300", "Dell Vostro", "Laptop", "75000"), new Product("400", "Usha", "Fan", "5000"), 
          new Product("500", "Dell Inspiran", "Laptop", "6000"),new Product("600", "Lenovo Fix", "Laptop", "7000"))
      .collect(Collectors.toList());

  public List<Product> getAllProducts() {
    return products;
  }

  public Product getProductById(String id) {
    return products.stream().filter(e -> e.getId().equals(id)).findFirst().get();
  }

  public void addProduct(Product[] product) {
    for(Product prod: product) {
    System.out.println("product: "+ prod.getId());
    products.add(prod);
    }
  }

  public void updateProduct(Product product, String id) {
    System.out.println(product.toString());
    for (int i = 0; i < products.size(); i++) {
      Product currentProduct = products.get(i);

      if (currentProduct.getId().equals(id)) {
        products.set(i, product);
        return;
      }
    }
  }

  public void deleteProduct(String id) {
    products.remove(getProductById(id));
  }
}
