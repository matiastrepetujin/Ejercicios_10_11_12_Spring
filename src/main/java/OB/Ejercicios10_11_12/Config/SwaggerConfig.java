package OB.Ejercicios10_11_12.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


/**
 * Configuracion Swagger para la generacion de documentacion de la API REST
 *
 * HTML: http://localhost:8080/swagger-ui/
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class SwaggerConfig {

    @Bean
    public InternalResourceViewResolver resolucionVistaPorDefault() {
        return new InternalResourceViewResolver();
    }

    @Bean
    public Docket api (){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Laptops API REST",
                "Librerias API REST docs",
                "1.0",
                "http://www.google.com",
                new Contact("Matias", "http://www.google.com", "matiastrepetujin@gmai.com"),
                "MIT",
                "https://www.google.com",
                Collections.emptyList());
    }

}
