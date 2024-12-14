package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class HexagonalArchitectureTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureTemplateApplication.class, args);
    }

}
