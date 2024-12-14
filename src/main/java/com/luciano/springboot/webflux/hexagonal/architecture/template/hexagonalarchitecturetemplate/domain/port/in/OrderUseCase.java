package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.in;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto.CreateOrderRequest;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto.OrderResponse;
import reactor.core.publisher.Mono;

public interface OrderUseCase {
    Mono<OrderResponse> createOrder(CreateOrderRequest request);
    Mono<OrderResponse> getOrderById(String id);
}
