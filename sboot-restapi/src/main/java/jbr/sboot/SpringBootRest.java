package jbr.sboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootRest {

    @Value("${cors.domain}")
    private String corsDomain;

    @Value("${cors.headers}")
    private String corsHeaders;

    @Value("${cors.methods}")
    private String corsMethods;

    @Value("${spring.data.rest.base-path}")
    private String basePath;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRest.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        log.info("corsDomain: {}", corsDomain);
        log.info("corsHeaders: {}", corsHeaders);
        log.info("corsMethods: {}", corsMethods);
        log.info("basePath: {}", basePath);

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(basePath + "/**")
                        .allowedOrigins(corsDomain.split(","))
                        .allowedHeaders(corsHeaders.split(","))
                        .allowedMethods(corsMethods.split(","))
                        .maxAge(3600);
            }
        };
    }

}
