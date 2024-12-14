package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.repositories;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.entities.OrderDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SpringDataMongoOrderRepository extends ReactiveMongoRepository<OrderDocument, String> {
}