package rj.sb.ms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import rj.sb.ms.model.Product;
import rj.sb.ms.model.Rating;
import rj.sb.ms.model.Wishlist;

@RestController
@RequestMapping("/user/wishlist")
public class WishlistController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private WebClient.Builder webClient;

  @RequestMapping("/{userid}")
  public List<Wishlist> getUserWishlist(@PathVariable("userid") String userid) {
    List<Wishlist> wishlists = Arrays.asList(new Wishlist("100", "", ""), new Wishlist("200", "", ""),
        new Wishlist("300", "", ""));
    return wishlists.stream()
        .map(wishlist ->
          {
            Product product = webClient.build()
                .get()
                .uri("http://localhost:6060/product/info/" + wishlist.getProductid())
                .retrieve()
                .bodyToMono(Product.class)
                .block();

            Rating rating = webClient.build()
                .get()
                .uri("http://localhost:7070/product/rating/" + wishlist.getProductid())
                .retrieve()
                .bodyToMono(Rating.class)
                .block();

            return new Wishlist(wishlist.getProductid(), product.getName(), rating.getRating());
          })
        .collect(Collectors.toList());

  }

  // @RequestMapping("/{userid}")
  public List<Wishlist> getUserWishlistUsingRestTemplate(@PathVariable("userid") String userid) {
    List<Wishlist> wishlists = Arrays.asList(new Wishlist("100", "", ""), new Wishlist("200", "", ""),
        new Wishlist("300", "", ""));

    return wishlists.stream()
        .map(wishlist ->
          {
            Product product = restTemplate.getForObject("http://localhost:6060/product/info/" + wishlist.getProductid(),
                Product.class);
            Rating rating = restTemplate.getForObject("http://localhost:7070/product/rating/" + wishlist.getProductid(),
                Rating.class);

            return new Wishlist(wishlist.getProductid(), product.getName(), rating.getRating());
          })
        .collect(Collectors.toList());

  }
}
