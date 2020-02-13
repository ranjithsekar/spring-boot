package rs.sb.graphql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

  @Value("classpath:product.graphql")
  Resource resource;
  
  private GraphQL graphql;
}

