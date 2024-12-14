package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.out;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepositoryPort {
    Mono<Order> saveOrder(Order order);
    Flux<Order> findAllOrders();
    Mono<Order> findOrderById(String id);
}
