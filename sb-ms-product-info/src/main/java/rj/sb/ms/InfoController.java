package rj.sb.ms;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rj.sb.ms.model.Product;

@RestController
@RequestMapping("/product/info")
public class InfoController {

  @RequestMapping("/{productid}")
  public Product ratingById(@PathVariable("productid") String productid) {
    return new Product("100", "Samsung", "1000");
  }
}
