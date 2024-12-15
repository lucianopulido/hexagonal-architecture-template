package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.adapter.in.controllers;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto.CreateOrderRequest;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto.OrderResponse;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.in.OrderUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderUseCase orderUseCase;

    public OrderController(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    @PostMapping
    public Mono<ResponseEntity<OrderResponse>> createOrder(@RequestBody CreateOrderRequest request) {
        return orderUseCase.createOrder(request)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().build()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<OrderResponse>> getOrder(@PathVariable String id) {
        return orderUseCase.getOrderById(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
