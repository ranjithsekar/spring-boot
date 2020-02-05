package rj.sb.ms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import rj.sb.ms.model.Product;
import rj.sb.ms.model.Rating;
import rj.sb.ms.model.Wishlist;

@RestController
@RequestMapping("/user/wishlist")
public class WishlistController {

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping("/{userid}")
  public List<Wishlist> getUserWishlist(@PathVariable("userid") String userid) {
    List<Wishlist> wishlists = Arrays.asList(new Wishlist("100", "", ""), new Wishlist("200", "", ""),
        new Wishlist("300", "", ""));

    return wishlists.stream().map(wishlist -> {
      Product product = restTemplate.getForObject("http://localhost:6060/product/info/" + wishlist.getProductid(),
          Product.class);
      Rating rating = restTemplate.getForObject("http://localhost:7070/product/rating/" + wishlist.getProductid(),
          Rating.class);

      return new Wishlist(wishlist.getProductid(), product.getName(), rating.getRating());
    }).collect(Collectors.toList());

  }
}
