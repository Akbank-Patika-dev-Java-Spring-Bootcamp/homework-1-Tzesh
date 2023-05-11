package com.tzesh;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Akbank Spring Boot HW1",
                version = "1.0",
                description = """
                        First Spring Boot Homework for Akbank Java Bootcamp. Long story short, this is a simple CRUD application for countries.
                        User can create, read, update and delete countries. Also, user can update president of a country.
                        This application uses Spring Boot, Spring Data JPA, H2 Database, Lombok, MapStruct, Swagger and Jakarta Bean Validation."""
        ),
        servers = {
                @io.swagger.v3.oas.annotations.servers.Server(
                        url = "http://localhost:8080/api/v1/",
                        description = "Local server"
                )
        },
        externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
                description = "Github repository",
                url = "https://github.com/Akbank-Patika-dev-Java-Spring-Bootcamp/homework-1-Tzesh")
)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
