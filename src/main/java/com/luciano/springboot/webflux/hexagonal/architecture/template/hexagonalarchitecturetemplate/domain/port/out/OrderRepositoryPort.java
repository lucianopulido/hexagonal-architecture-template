package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.out;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.entities.OrderDocument;
import reactor.core.publisher.Mono;

public interface OrderRepositoryPort {
    Mono<Order> saveOrder(OrderDocument order);

    Mono<Order> findOrderById(String id);
}
