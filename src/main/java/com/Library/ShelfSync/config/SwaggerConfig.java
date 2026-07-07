package com.Library.ShelfSync.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI CustomOpenAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("ShelfSync")
                                .description("ShelfSync is a production-oriented Library Management System backend built with Java, Spring Boot, Spring Security, and MySQL. It provides role-based access control, book inventory management, borrowing workflows, and fine management while following a scalable layered architecture and REST API best practices.")
                                .version("v1")
                                .contact(new Contact()
                                        .name("Shubham Karna")
                                        .email("skarna230@gmail.com"))
                )

        .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))


                .components(new Components()
                        .addSecuritySchemes("BearerAuth" ,
                                new SecurityScheme()
                                        .name("Auth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );


    }

}
