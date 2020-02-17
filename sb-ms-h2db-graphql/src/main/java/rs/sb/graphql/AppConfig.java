package rs.sb.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.sb.graphql.resolver.Mutation;
import rs.sb.graphql.resolver.Query;

@Configuration
public class AppConfig {
  @Bean
  public Query query() {
    return new Query();
  }

  @Bean
  public Mutation mutation() {
    return new Mutation();
  }

}
