package jbr.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebshopMsApplication {

    @Value("${cors.domain}")
    private String corsDomain;

    @Value("${cors.headers}")
    private String corsHeaders;

    @Value("${cors.methods}")
    private String corsMethods;
	
	public static void main(String[] args) {
		SpringApplication.run(WebshopMsApplication.class, args);
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
                registry.addMapping(basePath + "/**").allowedOrigins(corsDomain.split(","))
                        .allowedHeaders(corsHeaders.split(",")).allowedMethods(corsMethods.split(",")).maxAge(3600);
            }
        };
    }


}
