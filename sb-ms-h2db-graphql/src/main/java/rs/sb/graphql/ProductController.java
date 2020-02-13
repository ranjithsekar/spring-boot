package rs.sb.graphql;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	
	@PostMapping
	public ResponseEntity<Object> getAllProducts(@RequestBody String query) {
		log.info("enter - getAllProducts()");

		//
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
