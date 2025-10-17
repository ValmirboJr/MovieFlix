package org.example.movieflix.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {

        Info info = new Info();

        Contact contact = new Contact();
        contact.name("Valmir");
        contact.email("valmirborgesojr@gmails.com");


        info.setTitle("Movie Flix");
        info.version("v1");
        info.description("Aplicação focada em gerenciamento de um catalogo de filmes");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
