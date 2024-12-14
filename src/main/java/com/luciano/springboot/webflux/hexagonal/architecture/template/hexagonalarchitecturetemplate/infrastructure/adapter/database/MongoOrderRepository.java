package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.adapter.database;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.out.OrderRepositoryPort;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.entities.OrderDocument;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.repositories.SpringDataMongoOrderRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MongoOrderRepository implements OrderRepositoryPort {

    private final SpringDataMongoOrderRepository repository;

    public MongoOrderRepository(SpringDataMongoOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Order> saveOrder(Order order) {
        return repository.save(OrderDocument.fromDomain(order))
                         .map(OrderDocument::toDomain);
    }

    @Override
    public Flux<Order> findAllOrders() {
        return repository.findAll().map(OrderDocument::toDomain);
    }

    @Override
    public Mono<Order> findOrderById(String id) {
        return repository.findById(id).map(OrderDocument::toDomain);
    }
}